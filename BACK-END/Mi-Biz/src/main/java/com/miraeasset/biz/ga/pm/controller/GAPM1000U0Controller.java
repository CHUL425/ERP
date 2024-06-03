/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GAPM1000U0Controller.java
*	04. 작  성  일  자	: 2023.07.03
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 정기주차권관리 컨트롤러
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ga.pm.controller;


import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.miraeasset.biz.common.exception.CustomRequestException;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.excel.ExcelFile;
import com.miraeasset.biz.common.util.excel.ExcelUpload;
import com.miraeasset.biz.common.util.excel.OneSheetExcelFile;
import com.miraeasset.biz.common.vo.CommonResponse;
import com.miraeasset.biz.ga.pm.service.GAPM1000U0Service;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0In00VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0In01VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0In02VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0In03VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0In10VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0Out00VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0Out01VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0Out10VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0Out11VO;

import io.swagger.annotations.ApiOperation;


@Controller
@RequestMapping("/api/main/gapm1000u0")
public class GAPM1000U0Controller extends CustomRequestException{
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	GAPM1000U0Service GAPM1000U0Service;
	
	@Autowired
	ExcelUpload exl;	

	/**
	 * 정기주차권관리 목록조회
	 */
	@ApiOperation(value="정기주차권관리 목록조회")
	@RequestMapping(value= "/selectListGA01N203", method = RequestMethod.POST)
	@ResponseBody
	public  List<GAPM1000U0Out00VO> selectListGA01N203(@RequestBody GAPM1000U0In00VO vo, HttpServletRequest request) {
		return GAPM1000U0Service.selectListGA01N203(vo);
	}	

	/**
	 * 정기주차권관리 상세정보조회(PK)
	 */
	@ApiOperation(value="정기주차권관리 상세정보조회(PK)")
	@RequestMapping(value= "/selectGA01N203PK", method = RequestMethod.POST)
	@ResponseBody
	public  List<GAPM1000U0Out01VO> selectGA01N203PK(@RequestBody GAPM1000U0In01VO vo, HttpServletRequest request) {
		return GAPM1000U0Service.selectGA01N203PK(vo);
	}
	
	/**
	 * 정기주차권관리 수정(PK)
	 */
	@ApiOperation(value="정기주차권관리 수정(PK)")
	@RequestMapping(value= "/updateGA01N203", method = RequestMethod.POST)
	@ResponseBody
	public  CommonResponse updateGA01N203(@RequestBody GAPM1000U0In02VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		response.addData(GAPM1000U0Service.updateGA01N203(vo));		
		return response;
	}	
	
	/**
	 * 정기주차권관리 삭제
	 */
	@ApiOperation(value="정기주차권관리 삭제")
	@RequestMapping(value= "/deleteInfo", method = RequestMethod.POST)
	@ResponseBody
	public  CommonResponse deleteGA01N203(@RequestBody GAPM1000U0In02VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		response.addData(GAPM1000U0Service.deleteGA01N203(vo));		
		return response;
	}		

	/**
	 * 정기주차권관리 신규등록
	 */
	@ApiOperation(value="정기주차권관리 신규등록")
	@RequestMapping(value= "/insertGA01N203", method = RequestMethod.POST)
	@ResponseBody
	public  CommonResponse insertGA01N203(@RequestBody GAPM1000U0In03VO vo, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		response.addData(GAPM1000U0Service.insertGA01N203(vo));		
		return response;
	}	

	/**
	 * 정기주차권관리 주차대수요약정보
	 */
	@ApiOperation(value="정기주차권관리 주차대수요약정보")
	@RequestMapping(value= "/selectParkCntInfo", method = RequestMethod.POST)
	@ResponseBody
	public  List<GAPM1000U0Out11VO> selectParkCntInfo(HttpServletRequest request) {
		return GAPM1000U0Service.selectParkCntInfo();
	}		
	
	/**
	 * 정기주차권관리 유무료주차대수조회
	 */
	@ApiOperation(value="정기주차권관리 유무료주차대수조회")
	@RequestMapping(value= "/selectParkCnt", method = RequestMethod.POST)
	@ResponseBody
	public  List<GAPM1000U0Out10VO> selectParkCnt(HttpServletRequest request) {
		return GAPM1000U0Service.selectParkCnt();
	}		
	
	/**
	 * 정기주차권관리 유무료주차대수 수정
	 */
	@ApiOperation(value="정기주차권관리 유무료주차대수 수정")
	@RequestMapping(value= "/updateParkCnt", method = RequestMethod.POST)
	@ResponseBody
	public  int updateParkCnt(@RequestBody GAPM1000U0In10VO vo, HttpServletRequest request) {
		return GAPM1000U0Service.updateParkCnt(vo);
	}	

	/**
	 * 정기주차권관리 엑셀다운로드
	 */
	@ApiOperation(value="정기주차권관리 엑셀다운로드")
	@RequestMapping(value= "/excel", method = RequestMethod.POST, consumes = "multipart/form-data")
	public @ResponseBody void downloadExcel(GAPM1000U0In00VO vo, HttpServletResponse response) throws IOException {

		String fileName = "정기주차권관리내역_"+DateUtil.getDate()+".xlsx";
		String downFileName = URLEncoder.encode(fileName, "UTF-8");
		response.setHeader("Content-Disposition", "attachment; fileName=\""+downFileName +"\"");
		
		List<GAPM1000U0Out00VO> list = GAPM1000U0Service.selectListGA01N203(vo);
		ExcelFile<GAPM1000U0Out00VO> excelFile = new OneSheetExcelFile<>(list, GAPM1000U0Out00VO.class);
		excelFile.write2(response, downFileName);
	}	
	
	/*
	 * 엑셀 업로드
	 */
	@ApiOperation(value="정기주차권관리 엑셀업로드")	
	@RequestMapping(value= "/excelup", method = RequestMethod.POST)
	public @ResponseBody int uploadExcel(MultipartHttpServletRequest request) throws Exception {
		MultipartFile excelFile = request.getFile("excelFile");
		// pk column dupChk
		String[] chkCol = { "chfTcd", "vhcNo", "vhcPcd","userOrzCd"};
//		List<Map<String, Object>>list = exl.excelFileUpload(excelFile, GARM1000ExcelVO.class, chkCol);
		
		// 임시 차후 key, seq로 DB에서 가져옴
		String field = "chfTcd,vhcNo,vhcPcd,userOrzCd,userEpNm,userEpno,hrPstNm,blbdTcdNm,nteCn";
		String [] fieldName = field.split(",");
		List<String> fieldNameList = new ArrayList<String>();
		for (String col : fieldName) {
			fieldNameList.add(col);
		}
		
		/*
		 *  1.excelFile, pk col, field(default key(화면ID) = excelFile.getName(), seq = "01", strtRowIdx = 2)
		 *  2.excelFile, pk col, key(화면ID), seq, field, strtRowIdx
		 *  fieldNameList이 없을시 key, seq로 해당 col정보 조회
		 */
		List<Map<String, Object>>list = exl.excelFileUpload(excelFile, chkCol, "", "", fieldNameList, 1);
		return GAPM1000U0Service.excelUpload(list);
	}	
	
/*
	@ApiOperation(value="정기주차권관리 엑셀업로드")
	@RequestMapping(value = "/uploadExcel", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse uploadExcel(@RequestParam HashMap<String, String> frmData,
									 MultipartHttpServletRequest mpFiles, HttpServletRequest request)
	{
		CommonResponse response = new CommonResponse();

		
		FileUploadVO fuvo = new FileUploadVO(); 	
		fuvo.setMf(mpFiles.getMultiFileMap());

		//업로드 유저 정보
		LoginOutVO loginUser = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
		fuvo.setLoginUser(loginUser);
		
		response.addData(GAPM1000U0Service.uploadExcel(fuvo));
		return response;
	}
*/	
	
}

