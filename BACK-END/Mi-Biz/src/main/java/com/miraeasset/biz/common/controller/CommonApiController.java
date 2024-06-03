package com.miraeasset.biz.common.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.fasoo.adk.packager.WorkPackager;
import com.miraeasset.biz.common.annotation.AllAuth;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.CustomNotFoundException;
import com.miraeasset.biz.common.exception.NoSessionException;
import com.miraeasset.biz.common.exception.vo.CommonErrorResponse;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.common.meta.vo.GA09N411VO;
import com.miraeasset.biz.common.meta.vo.GA09N411Vs01InVO;
import com.miraeasset.biz.common.service.CommonService;
import com.miraeasset.biz.common.util.CommonUtil;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.massage.MsgSenService;
import com.miraeasset.biz.common.vo.CommonResponse;
import com.miraeasset.biz.common.vo.FileVO;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("/api/common")
public class CommonApiController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CommonService commonService;

	@Value("${file.nas.path}")
	private String fileNasPath;

	@Value("${file.viewer.url}")
	private String fileViewerUrl;	
	
	@SuppressWarnings("FieldCanBeLocal")
	private final String fasooHomeDir = "/FASOO/config/fsdinit";

	@SuppressWarnings("FieldCanBeLocal")
	private final String fasooServerID = "0000000000012471";

	@Value("${SYSTEM_NAME}")    
	private String SYSTEM_NAME;  /* local/dev/test/real */

	@Value("${LOC_UPLOAD_PATH}")
	private String LOC_UPLOAD_PATH;
	
	@Value("${SEV_UPLOAD_PATH}")
	private String SEV_UPLOAD_PATH;

	@Value("${SEV_DOWNLOAD_PATH}")
	private String SEV_DOWNLOAD_PATH;
	
	@Value("${LOC_DOWNLOAD_PATH}")
	private String LOC_DOWNLOAD_PATH;	


	@Autowired
	MsgSenService msg;
	
	/**
	 * 삭제 예정
	 */
	@ApiIgnore
	@RequestMapping(value = "/test")
	public ModelAndView fileUpTest() {
		return new ModelAndView("uptest");
	}
	
	@ApiIgnore
	@RequestMapping(value = "/downFile")
	public ModelAndView dfile() {
		return new ModelAndView("downFile");
	}
	
	/**
	 * 이미지파일 첨부(blob)
	 */
	@ApiOperation(value="이미지파일 업로드")
	@RequestMapping(value = "/imgFile/up", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse createImgFile(@RequestParam HashMap<String, String> frmData,
									 MultipartHttpServletRequest mpFiles, HttpServletRequest request)
	{
		CommonResponse response = new CommonResponse();
		MultiValueMap<String, String> mapRtn = new LinkedMultiValueMap<>();
		
		GA09N411VO fVo = new GA09N411VO();
		
		String fileNo = "";
		fileNo = request.getParameter("fileNo");
		log.info("fileNo["+fileNo+"]");
		
		// 이미지 파일 고정위치 셋팅 
		String fileKcd = "";
		fileKcd = request.getParameter("fileKcd");
		log.info("fileKcd["+fileKcd+"]");
		
		
		if (StringUtils.isBlank(fileKcd)) {
			fileKcd = "01";
		}
		
		// 기존파일번호에 추가할지 신규로 채번할지 여부 체크
		boolean newFileNoYn = true;
		
		if(fileNo != null && !fileNo.equals("")) {
			newFileNoYn = false;
		}else {
			newFileNoYn = true;
		}
		
		String strExt;
		String strName;
		String strDir = SEV_UPLOAD_PATH;
		int cnt = 0;
		
		// UPLOAD 경로지정
		if(SYSTEM_NAME.equals("local")) {
			strDir = LOC_UPLOAD_PATH;
		}else {
			strDir = SEV_UPLOAD_PATH;
		}

		log.info("strDir["+strDir+"]");

		//파일 1개당 허용 용량 20MB
		final long limitSize = 20 * 1024 * 1024;

		//업로드 유저 정보
		LoginOutVO loginUser = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
		
		if( loginUser == null ) {
			loginUser = new LoginOutVO();
			loginUser.setEpno("0000000");
			loginUser.setEpNm("");
			loginUser.setBlngOrzCd("000000");
			loginUser.setNowWrkpOrzCd("000000");
			
		}
		log.info("loginUser["+loginUser+"]");
		
		long lngSize;

		int fileDlNo = 1;

		//파일 키 생성
		String newFileNo = "";
		if(newFileNoYn) {
			// 파일키 신규 채번
			newFileNo = commonService.selectNewFileNo();

		}else {
			// 파일키 기존 번호세팅
			newFileNo = fileNo;
			FileVO fileVo = new FileVO();
			
			// 파일 상세키 채번
			fileVo.setFileNo(newFileNo);
			fileDlNo = Integer.parseInt(commonService.selectNewFileDlNo(fileVo));
		}
		
		log.info("newFileNo["+newFileNo+"] fileDlNo["+fileDlNo+"]");
		//try {
			MultiValueMap<String, MultipartFile> fs = mpFiles.getMultiFileMap();
			for (Map.Entry<String, List<MultipartFile>> fileEnt : fs.entrySet()) {
				for (MultipartFile file : fileEnt.getValue()) {
					strName = file.getOriginalFilename();
					strExt = FilenameUtils.getExtension(strName);
					if (strExt != null) {
						strExt = strExt.toLowerCase();
					}
					lngSize = file.getSize();
					
					log.info("lngSize["+lngSize+"] strExt["+strExt+"]");
					
					if (file.isEmpty() && Objects.requireNonNull(strName).isEmpty()) {
						System.out.println("Empty");
					} else if (lngSize == 0) {
						mapRtn.add("error", strName + " - 파일 내용을 다시 확인해 주세요.");
					} else if (lngSize > limitSize) {
						mapRtn.add("error", strName + " - 등록 가능한 첨부파일의 크기는 최대 20MB 입니다.");
					}
					else if (!Arrays.asList("doc","docx","hwp","jpeg","jpg","mp4","bmp","pdf","png","ppt","pptx","tif","txt","xls","xlsm","xlsx","zip","htm","html").contains(strExt)) {
						mapRtn.add("error", strName + " - 지원하지 않는 확장자 입니다.");
					}
					else if (StringUtils.indexOfAny(strName, new String[]{";", "./", "%0", "&", ".\\"}) > -1) {
						log.info("createFile - 인젝션 의심 파일 로그 : " + strName);
						log.info("form data 상세 정보 - " + frmData);
						mapRtn.add("error", strName + " - 파일 이름을 다시 확인해 주세요. (;,%0,&,/,\\ 사용 불가)");
					} else {
						byte[] img = null;
						boolean bret = false;
						//키 이름 으로 파일 업로드
						try{
							log.info("strDir ["+strDir+"] File.separator ["+File.separator+"] newFileNo["+newFileNo+"] fileDlNo["+fileDlNo+"] strExt["+strExt+"] strName["+strName+"]");
							
							img = file.getBytes();
//						fVo.setAtcFileImg(file.getBytes());
							
							// 2024.03.27 Sparrow 오류로 수정
							String spNm = strDir + File.separator + newFileNo + "-" + fileDlNo;
							if(spNm!=null && !"".equals(spNm)){
							    //spNm = spNm.replaceAll(".",""); // 파일업로드실패로 수정
							    spNm = spNm.replaceAll("",""); // 파일업로드실패로 수정
							}
							//File dest = new File(strDir + File.separator + newFileNo + "-" + fileDlNo);
							 File dest = new File(spNm);
							
							
							file.transferTo(dest);
							
							WorkPackager oWorkPackager = new WorkPackager();
							
							//파일 타입 확인, 임시 로그 생성 중_2023-01-30
							int iRet = oWorkPackager.GetFileType(strDir + File.separator + newFileNo + "-" + fileDlNo);
							log.info(String.valueOf(iRet));
							
							if (iRet == 103) {
								//파일 복호화 진행
								bret = oWorkPackager.DoExtract(
										fasooHomeDir,
										fasooServerID,
										strDir + File.separator + newFileNo + "-" + fileDlNo,
										strDir + File.separator + newFileNo + "-" + fileDlNo);
	        					log.info("복호화 결과값 : {}", bret);
	        					log.info("복호화 문서 : {}", oWorkPackager.getContainerFilePathName());
	        					log.info("오류코드 : {}", oWorkPackager.getLastErrorNum());
	        					log.info("오류값 : {}", oWorkPackager.getLastErrorStr());
	        					
	        					if (!bret) {
	        						log.info("오류코드 : " + oWorkPackager.getLastErrorNum() + " / 오류값 : " + oWorkPackager.getLastErrorStr());
	        						log.info("암호화문서 : " + oWorkPackager.getContainerFilePathName());
	        					}
							}
							else if (iRet == 101) {
								log.info("파일형태는 " + FileTypeStr(iRet) + "["+iRet+"]"+" 입니다.");
								log.info("MarkAny 파일은 암호화 불가능 합니다.");
							}
							else {
								log.info("일반 파일이 아닌경우 암호화 불가능 합니다.["+ iRet + "]");
							}
							
							// 암호화 와 업로드 성공 유무는 따로 처리
							mapRtn.add("success", strName + " - success");
							
							
							log.info("---> ["+strDir + File.separator + newFileNo + "-" + fileDlNo+"]");
							// 업로드 완료 파일 기준 사이즈 다시 체크
							Path compPath = Paths.get(strDir + File.separator + newFileNo + "-" + fileDlNo);
							
							log.info("compPath["+compPath+"]");
							
							lngSize = Files.size(compPath);
							
							log.info("---> lngSize["+lngSize+"]");
							
							fVo.setFileNo(newFileNo);
							fVo.setFileDlNo(fileDlNo+"");
							fVo.setFileKcd(fileKcd);
							fVo.setFileNm(strName); // 논리명(화면에서 올리는 파일명)
							fVo.setFileSize(lngSize);
							fVo.setAtcFilePathNm(strDir + File.separator);
							fVo.setAtcFilePhysNm(newFileNo + "-" + fileDlNo);
							//fVo.setAtcFileImg(file.getBytes());
							
							fVo.setUseYn("1");
							fVo.setOptrId(loginUser.getEpno());
							fVo.setOprtChnlCd("");
							fVo.setOprtOrzCd(loginUser.getNowWrkpOrzCd());
							fVo.setOprtIpAdr(loginUser.getConnIp());
							
							log.info(fVo.toString());
							
							//업로드 성공 시 DB 입력
							cnt = commonService.updateImgGA09N411(fVo);
							if (cnt > 0) {
								fVo.setAtcFileImg(img);
								commonService.updateImgFile(fVo);
							}
						} catch (IOException ex) {
							mapRtn.add("error", strName + " - 업로드 실패. 관리자 에게 문의 해주세요.");
							log.info(CommonUtil.getCauseFirst(ex));
						}
					}
					if(fileDlNo<0) return response; // 2024.03.27 Sparrow 오류로 추가
					fileDlNo++;
				}
			}
			
			// 신규채번시 채번 업데이트
			if(newFileNoYn && cnt > 0 ) {
				//파일번호 채번 업데이트
				commonService.updateFileChaebun(newFileNo);
			}
			response.addData(mapRtn);
			response.addData(fVo);
		//} catch (IOException e) {
		//	return response;
		//}
		return response;
	}	
	
	/**
	 * 파일 API - fasoo_jni_2.8 - GetFileType Value - 참조 추가 시 util 로 변경 예정
	 */
	public String FileTypeStr(int i)
	{
		String ret = null;
		switch(i)
		{
			case 20 : ret = "파일을 찾을 수 없습니다."; break;
			case 21 : ret = "파일 사이즈가 0 입니다.";  break;
			case 22 : ret = "파일을 읽을 수 없습니다."; break;
			case 29 : ret = "평문파일입니다.";  break;
			case 101: ret = "MarkAny 파일입니다.";   	break;
			case 103: ret = "정상적인 암호화 파일입니다."; break;
		}
		return ret;
	}


	/**
	 * 파일 API - SA09N003, TSK_ID 기준 파일 조회
	 */
	@RequestMapping(value = "/file/dn/tsk", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse selectGetFileByKey(@RequestBody FileVO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();

		LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");

		if(loginVo.getEpno().length() > 3){
			List<Map<String, Object>> lstVo = commonService.selectSa09n013ByKey(vo);
			response.addData(lstVo);
		}

		return response;
	}

	/**
	 * 파일 API - 삭제
	 */
	@ApiIgnore
	@RequestMapping(value = "/file/del", method = RequestMethod.POST)
	public @ResponseBody CommonResponse deleteFileByKey(@RequestBody FileVO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		Map<String, Object> mapRtn = new HashMap<>();

		LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("LoginOutVO");
		if(loginVo.getEpno().length() > 3)
		{
			//파일 삭제 후 DB 업데이트
			vo = commonService.selectSa09n013ByAtcFileGuid(vo);

			Path filePath = Paths.get(vo.getAtcFilePathNm() + File.separator +  vo.getAtcFilePhysNm());
			try{
				//복제 된 파일이 있는지 확인
				Map<String, Object> mapCnt = commonService.selectSa09n013ByAtcFileGuidCount(vo);
				if (Integer.parseInt(mapCnt.get("cnt").toString()) < 2) {
					Files.deleteIfExists(filePath);
				}

				vo.setOptrId(loginVo.getEpno());
				vo.setOprtChnlCd("");
				vo.setOprtOrzCd(loginVo.getNowWrkpOrzCd());
				vo.setOprtIpAdr(loginVo.getConnIp());

				mapRtn.put("result", commonService.updateSa09n013ByDelYn(vo));
			} catch (IOException ext) {
				log.info(ext.getMessage());
				mapRtn.put("error", ext.getMessage());
			}
		}

		response.addData(mapRtn);
		return response;
	}

	/**
	 * 파일 API - 원장 사용여부 삭제
	 */
	@ApiOperation(value="파일삭제 - 원장 사용여부 Y")
	@RequestMapping(value = "/file/updateDelGA09N411", method = RequestMethod.POST)
	public @ResponseBody CommonResponse updateDelGA09N411(@RequestBody GA09N411VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();

		response.addData(commonService.updateDelGA09N411(vo));
		return response;
	}

	/**
	 * 첨부파일 목록조회	
	 */
	@ApiOperation(value="첨부파일 목록조회")
	@RequestMapping(value= "/file/selectListGA09N411", method = RequestMethod.POST)
	@ResponseBody
	public  List<GA09N411VO> selectListGA09N411(@RequestBody GA09N411VO vo, HttpServletRequest request) {
		if(vo.getFileNo() == null) {
			throw new CustomBadRequestException("파일번호가 없어요.", ErrorCode.BAD_REQUEST);
		}

		boolean isErp = vo.getFileNo().substring(0,4).equals("ERP_");
		if(isErp) {
			return commonService.selectListAT09N411(vo);
		} else {
			return commonService.selectListGA09N411(vo);
		}
	}
	
	/**
	 * 첨부파일 목록조회	
	 */
	@ApiOperation(value="첨부파일 목록조회_이름검색")
	@RequestMapping(value= "/file/selectListGA09N411ByName", method = RequestMethod.POST)
	@ResponseBody
	public  List<GA09N411VO> selectListGA09N411ByName(@RequestBody GA09N411VO vo, HttpServletRequest request) {
		return commonService.selectListGA09N411ByName(vo);
	}	
	
	

	/* ***************** Common ***************** */
	
	@ExceptionHandler(value = NoSuchElementException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	protected ResponseEntity<CommonErrorResponse> handleNoSuchElementException(Exception e){
		CommonErrorResponse response = CommonErrorResponse.of(ErrorCode.RESOURCE_NOT_FOUND);
		response.setDetail(e.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = CustomBadRequestException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	protected ResponseEntity<CommonErrorResponse> handleCustombadRequestException(CustomBadRequestException e){
		CommonErrorResponse response = CommonErrorResponse.of(ErrorCode.BAD_REQUEST);
		response.setDetail(e.getMessage());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = CustomNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	protected ResponseEntity<CommonErrorResponse> handleCustomNotFoundException(CustomNotFoundException e){
		CommonErrorResponse response = CommonErrorResponse.of(ErrorCode.RESOURCE_NOT_FOUND);
		response.setDetail(e.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
    @ExceptionHandler(value = NoSessionException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
	protected ResponseEntity<CommonErrorResponse> handleNoSessionException(NoSessionException e){
		CommonErrorResponse response = CommonErrorResponse.of(ErrorCode.UNAUTHORIZED);
		response.setDetail(e.getMessage());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

    @ExceptionHandler(value = Exception.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	protected ResponseEntity<CommonErrorResponse> handleException(Exception e){
		CommonErrorResponse response = CommonErrorResponse.of(ErrorCode.INTERNAL_SERVER_ERROR);
		response.setDetail(e.getMessage());
		log.error(e.getMessage(), e.getCause());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * 첨부파일명 변경후 리턴(모바일뷰)
	 */
	@ApiOperation(value="첨부파일명 변경후 리턴(모바일뷰)")
	@RequestMapping(value= "/file/downFileNew", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody
	public String downFileNew(@RequestBody GA09N411Vs01InVO inVo, HttpServletResponse response) throws IOException {
		//String rtnPath = "";
		String fileNo = inVo.getFileNo();
		String fileDlNo = inVo.getFileDlNo();
		
		GA09N411VO vo = new GA09N411VO();

		// 필수값 체크
		{
			if(fileNo == null || "".equals(fileNo) ) {
				log.info("필수값 체크 오류 fileNo는 필수 입력값입니다");
				throw new CustomBadRequestException("필수값 체크 오류 fileNo는 필수 입력값입니다.", ErrorCode.BAD_REQUEST);
			}
			if(fileDlNo == null || "".equals(fileDlNo) ) {
				throw new CustomBadRequestException("필수값 체크 오류 fileDlNo는 필수 입력값입니다.", ErrorCode.BAD_REQUEST);
				
			}
	
			vo.setFileDlNo(fileDlNo);
			vo.setFileNo(fileNo);
		}

		// 파일정보원장조회
		{
			vo = commonService.selectGA09N411PK(vo);
			
			if(vo == null || vo.getFileNo() == null || vo.getFileDlNo() == null) {
				// 해당파일이 존재하지 않습니다.
				throw new CustomBadRequestException("해당파일이 원장에 존재하지 않습니다. 입력값을 확인하세요 ["+fileNo+"]["+fileDlNo+"]", ErrorCode.BAD_REQUEST);
			}
		}

		String phyFileName = vo.getAtcFilePhysNm(); // 물리파일명
		String lgcFileName = vo.getFileNm()       ; // 논리파일명
		
		int index = lgcFileName.lastIndexOf(".");
		String extsn = lgcFileName.substring(index);
		SecureRandom rd = new SecureRandom();
		
		// newFileNm = 20240327 + 103739 + 9 + File Extension
		String newFileNm = DateUtil.getDate() + DateUtil.getTime() +rd.nextInt(10) + extsn;
		
		// 파일위치
		String oFileDir;
		String tFileDir;
		
		// 서버경로 설정
		{ 
			if(SYSTEM_NAME.equals("local")) {
				oFileDir   = LOC_UPLOAD_PATH;
				tFileDir   = LOC_DOWNLOAD_PATH;
			}else {
				oFileDir   = SEV_UPLOAD_PATH;
				tFileDir   = SEV_DOWNLOAD_PATH;
			}		
		}
		
		String oFileFullPath    = oFileDir + File.separator + phyFileName; // 원본소스파일
		String tFileFullPath    = tFileDir + File.separator + newFileNm;   // 다운로드파일(원본카피) = 다운로드파일위치 + 실제파일명(로직컬파일이름)
		//String tFileFullPath    = tFileDir + File.separator + lgcFileName; // 다운로드파일(원본카피) = 다운로드파일위치 + 실제파일명(로직컬파일이름)
		
		//rtnPath = tFileDir+lgcFileName;
		String rtnFileNm = newFileNm;
		
		// 원본파일 -> 다운로드위치+로지컬파일명 카피후 파일객체 리턴
		{
			//try{

				log.info("원본파일 : " + oFileFullPath);
				
				File oFile = new File(oFileFullPath);
				
				if(!oFile.exists()) {
					log.info("원본파일이 존재하지않습니다. ");
					// 해당파일이 서버에 존재하지 않습니다. 
					throw new CustomBadRequestException("해당파일이 서버에 존재하지 않습니다.  ["+oFileFullPath+"]", ErrorCode.BAD_REQUEST);
				}
				
				File tFile = new File(tFileFullPath);
				log.info("tFile path : " + tFile.toPath());
				
				Files.copy(oFile.toPath(), tFile.toPath(),StandardCopyOption.REPLACE_EXISTING);
				log.info("카피완료 : " + oFileFullPath);
				
				// 파일 다운로드 처리
				/*{
					String downFileName = URLEncoder.encode(lgcFileName, "UTF-8");
					DateUtil.setResponseDownload(response, downFileName, tFileFullPath);
											
					if(!tFile.exists()) {
						log.info("다운로드파일이 존재하지않습니다. ");
						// 해당파일이 서버에 존재하지 않습니다. 
						throw new CustomBadRequestException("다운로드파일이 서버에 존재하지 않습니다. 카피오류  ["+tFileFullPath+"]", ErrorCode.BAD_REQUEST);
					}else {
						// 생성된 파일 삭제
		        		tFile.delete();
					}
				}*/

			///} catch(Exception ex) {
			//	log.info(CommonUtil.getCauseFirst(ex));
			//}				
		}

		//return rtnPath;
		return rtnFileNm;
	}    
	
	/**
	 * 첨부파일 다운로드
	 */
	@ApiOperation(value="첨부파일 다운로드")
	@RequestMapping(value= "/file/downFile", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	@AllAuth 
	public synchronized void downFile(@RequestBody GA09N411Vs01InVO inVo, HttpServletResponse response) throws IOException {
		
		String fileNo = inVo.getFileNo();
		String fileDlNo = inVo.getFileDlNo();
		
		GA09N411VO vo = new GA09N411VO();

		// 필수값 체크
		{
			if(fileNo == null || "".equals(fileNo) ) {
				log.info("필수값 체크 오류 fileNo는 필수 입력값입니다");
				throw new CustomBadRequestException("필수값 체크 오류 fileNo는 필수 입력값입니다.", ErrorCode.BAD_REQUEST);
			}
			if(fileDlNo == null || "".equals(fileDlNo) ) {
				throw new CustomBadRequestException("필수값 체크 오류 fileDlNo는 필수 입력값입니다.", ErrorCode.BAD_REQUEST);
				
			}
	
			vo.setFileDlNo(fileDlNo);
			vo.setFileNo(fileNo);
		}
		/* ERP 여부 확인. ERP 파일은 파일번호에 "ERP_"가 붙는다. */
		boolean isErp = vo.getFileNo().startsWith("ERP_");
		log.info("################################");
		log.info("###########[파일번호]: " + vo.getFileNo());
		log.info("###########[ERP파일여부]: " + isErp);
		log.info("################################");

		if(isErp) {
			vo.setFileNo(vo.getFileNo().replace("ERP_", ""));
		}
		
		// 파일정보원장조회
		{
			if(isErp) {
				vo = commonService.selectOneAT09N411(vo);
			} else {
				vo = commonService.selectGA09N411PK(vo);
			}

			
			if(vo == null || vo.getFileNo() == null || vo.getFileDlNo() == null) {
				// 해당파일이 존재하지 않습니다.
				throw new CustomBadRequestException("해당파일이 원장에 존재하지 않습니다. 입력값을 확인하세요 ["+fileNo+"]["+fileDlNo+"]", ErrorCode.BAD_REQUEST);
			}
		}

		String phyFileName = vo.getAtcFilePhysNm(); // 물리파일명
		String lgcFileName = vo.getFileNm()       ; // 논리파일명
		
		// 파일위치
		String oFileDir;
		String tFileDir;
		
		// 서버경로 설정
		{ 
			if(SYSTEM_NAME.equals("local")) {
				oFileDir   = isErp ? "/biz/"+vo.getAtcFilePathNm() : LOC_UPLOAD_PATH;
				tFileDir   = LOC_DOWNLOAD_PATH;
			}else {
				oFileDir   = isErp ? "/biz/"+vo.getAtcFilePathNm() : SEV_UPLOAD_PATH;
				tFileDir   = SEV_DOWNLOAD_PATH;
			}		
		}
		
		String oFileFullPath    = oFileDir + File.separator + phyFileName; // 원본소스파일
		String tFileFullPath    = tFileDir + File.separator + lgcFileName; // 다운로드파일(원본카피) = 다운로드파일위치 + 실제파일명(로직컬파일이름)
		
		// 원본파일 -> 다운로드위치+로지컬파일명 카피후 파일객체 리턴
		{
			try{

				log.info("원본파일 : " + oFileFullPath);
				
				File oFile = new File(oFileFullPath);
				
				if(!oFile.exists()) {
					log.info("원본파일이 존재하지않습니다. ");
					// 해당파일이 서버에 존재하지 않습니다. 
					throw new CustomBadRequestException("해당파일이 서버에 존재하지 않습니다.  ["+oFileFullPath+"]", ErrorCode.BAD_REQUEST);
				}
				
				File tFile = new File(tFileFullPath);
				log.info("tFile path : " + tFile.toPath());
				
				Files.copy(oFile.toPath(), tFile.toPath(),StandardCopyOption.REPLACE_EXISTING);
				log.info("카피완료 : " + oFileFullPath);
				
				// 파일 다운로드 처리
				{
					String downFileName = URLEncoder.encode(lgcFileName, "UTF-8");
					DateUtil.setResponseDownload(response, downFileName, tFileFullPath);
											
					if(!tFile.exists()) {
						log.info("다운로드파일이 존재하지않습니다. ");
						// 해당파일이 서버에 존재하지 않습니다. 
						throw new CustomBadRequestException("다운로드파일이 서버에 존재하지 않습니다. 카피오류  ["+tFileFullPath+"]", ErrorCode.BAD_REQUEST);
					}
					// [20240509] sparrow 오류로 삭제
					//else {
						// 생성된 파일 삭제
					//	tFile.delete();
					//}
				}

			} catch(FileNotFoundException ex) {
				log.info(CommonUtil.getCauseFirst(ex));

				try{
					response.setContentType("text/html; charset=utf-8");
					PrintWriter out = response.getWriter();
					out.println(" / 다운로드 실패. 관리자 에게 문의 해주세요. / ");
					out.println(CommonUtil.getDateTimeFormat("yyyy-MM-dd HH:mm:ss"));
					out.flush(); 
					out.close();
				}catch(FileNotFoundException ignored){
					PrintWriter out = response.getWriter();
					out.println(" / 다운로드 실패. 관리자 에게 문의 해주세요.2 / ");
				}
			}				
		}

	}    
	
	/**
	 * 이미지파일 뷰
	 */
	@ApiOperation(value="첨부이미지파일 뷰")
	@RequestMapping(value= "/file/viewImageFile", method = RequestMethod.POST, consumes = "multipart/form-data")
	@ResponseBody
	public ResponseEntity<byte[]> viewImageFile(GA09N411Vs01InVO inVo, HttpServletRequest request)
	{

		//로그인 유저 정보 확인 + 권한 확인?
		LoginOutVO loginUser = (LoginOutVO) request.getSession().getAttribute("loginVO");
		
		if( loginUser == null ) {
			loginUser = new LoginOutVO();
			loginUser.setEpno("0000000");
			loginUser.setEpNm("");
			loginUser.setBlngOrzCd("000000");
			loginUser.setNowWrkpOrzCd("000000");
		}	
		
		//String fileNo = request.getParameter("fileNo");
		//String fileDlNo = request.getParameter("fileDlNo");
		String fileNo = inVo.getFileNo();
		String fileDlNo = inVo.getFileDlNo();
		GA09N411VO vo = new GA09N411VO();
		
		// 필수값 체크
		{
			if(fileNo == null || "".equals(fileNo) ) {
				log.info("필수값 체크 오류 fileNo는 필수 입력값입니다");
				throw new CustomBadRequestException("필수값 체크 오류 fileNo는 필수 입력값입니다.", ErrorCode.BAD_REQUEST);
			}
			if(fileDlNo == null || "".equals(fileDlNo) ) {
				throw new CustomBadRequestException("필수값 체크 오류 fileDlNo는 필수 입력값입니다.", ErrorCode.BAD_REQUEST);
				
			}
	
			vo.setFileDlNo(fileDlNo);
			vo.setFileNo(fileNo);
		}

		vo.setFileNo(fileNo);
		vo.setFileDlNo(fileDlNo);
		vo = commonService.selectGA09N411PK(vo);
		
		if(vo != null) {
			
			String saveFileName = vo.getAtcFilePhysNm();
			String viewFileName = vo.getFileNm();
			String strDir = vo.getAtcFilePathNm();

			// 이미지 확장자 정합성 검증
			{
				int lastIndex = viewFileName.lastIndexOf(".");
				if(lastIndex != -1) { // "."이 존재하는경우
					String strExt = (viewFileName.substring(lastIndex + 1).trim()).toLowerCase(); // 확장자 추출(소문자)
					
					if (!Arrays.asList("jpeg","jpg","png","tif","bmp").contains(strExt)) {
						//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
						throw new CustomBadRequestException("해당 파일은 이미지 파일이 아닙니다.["+viewFileName+"]", ErrorCode.BAD_REQUEST);						
					}
				}
				
			}
			
			if(SYSTEM_NAME.equals("local")) {
				strDir = "D:/Java/File/upload";
			}

			String downFileName = null;

			try{
				String agent = request.getHeader("User-Agent");
				if(agent.contains("Chrome") || agent.contains("MSIE") || agent.contains("Trident")){
					downFileName = URLEncoder.encode(viewFileName, "UTF-8").replaceAll("\\+", "%20");
				}
				else{
					downFileName = new String(viewFileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
				}

				byte[] byteArray = Files.readAllBytes(Paths.get(strDir + File.separator + saveFileName));
				
				HttpHeaders headers = new HttpHeaders();
				
				headers.setContentType(MediaType.IMAGE_PNG); // 이미지타입에 따라 변경
				
				return new ResponseEntity<>(byteArray,headers, HttpStatus.OK); // 물리파일을 읽어서 파일뷰
				//return new ResponseEntity<>(vo.getAtcFileImg(),headers, HttpStatus.OK); // blob 항목으로 파일뷰
				
			} catch(IOException ex) {
				log.info(CommonUtil.getCauseFirst(ex));
			}
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}	
	
	
	@RequestMapping(value= "/file/viewImage", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public void preview(GA09N411Vs01InVO inVo, HttpServletRequest request, HttpServletResponse response) {
		GA09N411VO vo = null;
		InputStream is = null;
		try {
			String fileNo = inVo.getFileNo();
			String fileDlNo = inVo.getFileDlNo();
			vo = new GA09N411VO();
			// 필수값 체크
			{
				if(fileNo == null || "".equals(fileNo) ) {
					log.info("필수값 체크 오류 fileNo는 필수 입력값입니다");
					throw new CustomBadRequestException("필수값 체크 오류 fileNo는 필수 입력값입니다.", ErrorCode.BAD_REQUEST);
				}
				if(fileDlNo == null || "".equals(fileDlNo) ) {
					throw new CustomBadRequestException("필수값 체크 오류 fileDlNo는 필수 입력값입니다.", ErrorCode.BAD_REQUEST);
					
				}
				vo.setFileDlNo(fileDlNo);
				vo.setFileNo(fileNo);
			}
			vo.setFileNo(fileNo);
			vo.setFileDlNo(fileDlNo);
			vo = commonService.selectGA09N411PK(vo);
			
			String contentType = "image/jpeg";
			response.setContentType(contentType);
			
			is = new ByteArrayInputStream(vo.getAtcFileImg());
			
			ServletOutputStream os = response.getOutputStream();
			int binaryRead;
			
			while((binaryRead = is.read()) != -1) {
				os.write(binaryRead);
			}
		} catch (Exception e) {
			throw new CustomBadRequestException("preview 오류발생", ErrorCode.BAD_REQUEST);
		} finally {
			if (is != null) try {
				is.close();
			} catch (IOException ex) {}
		}
		
	}
}
