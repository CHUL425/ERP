package com.miraeasset.biz.common.util.excel;

import java.io.*;
import java.util.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import com.miraeasset.biz.common.exception.CustomBadRequestException;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.miraeasset.biz.common.util.excel.utils.SuperClassReflectionUtils.getAllFields;

import com.miraeasset.biz.common.dao.ExcelColumnInfo;
import com.miraeasset.biz.common.exception.ErrMsgException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;

import com.fasoo.adk.packager.WorkPackager;

@Component
public class ExcelUpload {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Value("${file.nas.path}")
	private String fileNasPath;
	
	@Value("${SYSTEM_NAME}")
	private String SYSTEM_NAME;
	
	@Value("${SEV_FASOO_PATH}")
	private String SEV_FASOO_PATH;
	
	@Value("${LOC_FASOO_PATH}")
	private String LOC_FASOO_PATH;
	
	@Value("${FASOO_ID}")
	private String FASOO_ID;
	
	@Value("${SEV_UPLOAD_PATH}")
	private String SEV_UPLOAD_PATH;
	
	@Value("${LOC_EXCEL_UPLOAD_PATH}")
	private String LOC_EXCEL_UPLOAD_PATH;

	public List<Map<String, Object>> excelFileUpload(MultipartFile excelFile, String[] chkCol, List<String> fieldNameList) throws Exception {
		return this.excelFileUpload(excelFile, chkCol, excelFile.getName(), "01", fieldNameList, 2);
	}
	
	public List<Map<String, Object>> excelFileUpload(MultipartFile excelFile, String[] chkCol, int strtRow, Class<?> cls) throws Exception {

		List<String> colList = new ArrayList<String>();
		for (Field field : getAllFields(cls)) {
			// 엑셀 어노테이션 체크
			if (field.isAnnotationPresent(ExcelColumnInfo.class)) {
				colList.add(field.getName());
			}
		}
		return this.excelFileUpload(excelFile, chkCol, excelFile.getName(), "01", colList, strtRow);

	}
	
	public List<Map<String, Object>> excelFileUpload(MultipartFile excelFile, String[] chkCol, String key, String seq,  List<String> fieldNameList, int strtRow) throws Exception {

		InputStream  in  = null;
   	    OutputStream out = null;

   	    String dir = fileNasPath;
   	    String oHomeDir = "";
   	    
   	    if (SYSTEM_NAME.equals("local")) {
   	    	oHomeDir = LOC_FASOO_PATH;
   	    	dir = LOC_EXCEL_UPLOAD_PATH;
   	    } else {
   	    	oHomeDir = SEV_FASOO_PATH;
   	    	dir = SEV_UPLOAD_PATH;
   	    }
		
		String uid = UUID.randomUUID().toString();
		String oSourceFile = dir + uid + excelFile.getOriginalFilename().substring(excelFile.getOriginalFilename().lastIndexOf("."));
		String oTargetFile = dir + uid + "_bak" + excelFile.getOriginalFilename().substring(excelFile.getOriginalFilename().lastIndexOf("."));
		
		File src = new File(dir);
		if (!src.exists()) {
			src.mkdirs();
		}
		if (src.exists()) {
			try {
					in = excelFile.getInputStream();	
					out = new FileOutputStream(oSourceFile);
					int bytesRead = 0;
		    		byte[] buffer = new byte[8192];

		    		while ((bytesRead = in.read(buffer, 0, 8192)) != -1) {
		    			out.write(buffer, 0, bytesRead);
		    		}
		    		if(out != null) out.close();
		    		if(in  != null) in.close();
		    		
		    		boolean bret = false;
					boolean iret = false;
		    		
					boolean chkColYn = false;
                try {
                	WorkPackager fsa = new WorkPackager();
//                	log.info(String.valueOf(oSourceFile));
                	
                	log.info(" oHomeDir = {}, FASOO_ID = {}, oSourceFile = {}, oTargetFile = {}",oHomeDir,FASOO_ID,oSourceFile,oTargetFile);
                	
                	//파일 타입 확인
                	int iRet = fsa.GetFileType(oSourceFile);
                	log.info(String.valueOf(iRet));
                	
                	//파일 확장자 체크( IsSupportFile() ) 로직
        			iret = fsa.IsSupportFile(oHomeDir, FASOO_ID, oSourceFile);
        			log.info(String.valueOf(iret));
        			
        			if (iret == true) {
        				if (iRet == 103) {
        					bret = fsa.DoExtract(oHomeDir, FASOO_ID, oSourceFile, oTargetFile);
        					log.info("복호화 결과값 : {}", bret);
        					log.info("복호화 문서 : {}", fsa.getContainerFilePathName());
        					log.info("오류코드 : {}", fsa.getLastErrorNum());
        					log.info("오류값 : {}", fsa.getLastErrorStr());
        					if (!bret) {
        						log.info("오류코드 : " + fsa.getLastErrorNum() + " / 오류값 : " + fsa.getLastErrorStr());
        						log.info("암호화문서 : " + fsa.getContainerFilePathName());
        					}
        				} else {
        					oTargetFile = oSourceFile;
        				}
        				src = new File(oTargetFile);
//        				Workbook wb = ExcelFileType.getWorkbook(src.getAbsolutePath());
        				Workbook wb = WorkbookFactory.create(new File(oTargetFile));
        				Sheet st = wb.getSheetAt(0);
        				Row header = st.getRow(1);
        				int strtRowIdx = strtRow; 
        				
        				// 변경 예정 fieldNameList 여기에 없으면 DB 조회
        				// 셋팅된 VO 컬럼명 추춣
//        				List<String> fieldNameList = new ArrayList<String>();
//        				for (Field field : getAllFields(cla)) {
//        					fieldNameList.add(field.getName()); 
//        				}

        				// 변경 예정 fields -> fieldNameList로 사용 
        				// 추출 컬럼 fields 배열에 셋팅
        				String[] fields = new String[fieldNameList.size()];
        				for (int i = 0; i < fieldNameList.size(); i++) {
        					fields[i] = fieldNameList.get(i);
        					log.info(" fields = {} ", fields[i]);
        				}
        				
        				String error = "";
        				List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
        				List<Map<String, Object>> chkResult = new ArrayList<Map<String,Object>>();
        				
        				for (int i = strtRowIdx; i <= st.getLastRowNum(); i++) {

							try {

								Row row = st.getRow(i);
								Cell tempCell = st.getRow(i).getCell(1);
								Map<String, Object> map = new HashMap<String, Object>();
								Map<String, Object> chkMap = new HashMap<String, Object>();

								// 앞의 여러 컬럼이 빈 값 인 경우가 있어서 우선 주석 처리_2023-09-25
								// if (tempCell != null && !tempCell.toString().isEmpty()) {
								if (tempCell != null) {

	//        						st.getRow(strtRowIdx-1).getCell(i);
	//        						int colSize = row.getPhysicalNumberOfCells();
	//        						log.info("colSize = {}", colSize);
	//        						for (int k = 0; k <= colSize; k++) {
	//        							String ChkCol = st.getRow(strtRowIdx-1).getCell(0).toString();
	//        							log.info("ChkCol = {}", ChkCol);
	//        							if (ChkCol.equals(src))

									// k=컬럼 인덱스
									for (int k = 0; k <= fields.length-1; k++) {

										Cell kCell = row.getCell(k);
										String Cell = ExcelCellRef.getValue(kCell, wb);
										//인자값 셋팅
										String kCellData = Cell.toString();
	//        							log.info("{} - kCellData :: {}", k, kCellData);
	//        							log.info("{} - kCellData :: {}", fields[k], kCellData);
										map.put(fields[k], kCellData);

										// 중복체크 컬럼 데이터 셋팅
										if (chkCol == null) {
											// Skip
											chkColYn = true;
										} else {
											// pk값 데이터 존제여부 체크 및 중복체크를 위한 데이터 셋팅
											for (String keyCol : map.keySet()) {
	//        									log.info("keyCol = {}", keyCol);
												for (int j=0; j < chkCol.length; j++) {
													if (chkCol[j].equals(map.get(keyCol))) {
														if (map.get(keyCol) == null || map.get(keyCol).equals("")) {
															error = "필수데이터 ["+st.getRow(0).getCell(k)+"] 값이 존재하지않습니다.("+(k+strtRowIdx)+"열 "+(i+strtRowIdx)+"행)";
															break;
														} else {
															chkMap.put(keyCol, map.get(keyCol));
														}
													}
												}
											}
										}
									}
									result.add(map);
									chkResult.add(chkMap);
								} else {
									break;
								}

							}catch(Exception exFor){
								// 엑셀에 이상한 Row Data 가 있는 경우 Skip
								log.info("excelFileUpload errMsg-fexFor : {}", exFor.getMessage());
							}

        				}

        				if (!error.isEmpty() ) {
        					if (!chkColYn) {
        						// pk값 중복여부 체크
        						for (int i=0; i < chkResult.size(); i++) {
        							for (int j=0; j < i; j++) {
        								log.info("chkResult.get(i) : {} == chkResult.get(j) : {}", chkResult.get(i), chkResult.get(j));
        								if (chkResult.get(i).equals(chkResult.get(j))) {
        									error = "중복된 데이터가 존재합니다. 엑셀데이터를 확인해주세요.("+ (j + strtRowIdx) + "행과 "+(i + strtRowIdx)+"행이 중복)";
        									break;
        								}
        							}
        						}
        					}
        				}
        				if (!error.isEmpty() ) {
//        					throw new Exception(error);
        					throw new ErrMsgException(error, ErrorCode.EXCEL_FILE_READ_FAIL);
        				}
//        				log.info("result size {}", result.size);
        				if (error.isEmpty() && result.size() > 0) {
//            			log.info("result {}", result);
        					return result;
        				}
        			} else {
        				if (fsa.getLastErrorNum() == -1) {
//        					throw new CustomBadRequestException("user not set HomeDir or required property", ErrorCode.BAD_REQUEST);
        					throw new ErrMsgException("user not set HomeDir or required property", ErrorCode.EXCEL_DRM_NOT_FOUND);
        				} else {
//        					throw new Exception("not supported source file extension");
        					throw new ErrMsgException("not supported source file extension", ErrorCode.NOT_EXCEL_EXTENSION);
        				}
        			}
                } catch (Exception e) {
					// TODO: handle exception
                	log.info("errMsg {}", e.getMessage());
//                	throw new Exception(e.getMessage());
                	throw new ErrMsgException(e.getMessage(), ErrorCode.EXCEL_UPLOAD_FAIL);
				}
			} catch (FileNotFoundException e) {
				log.info("파일 에러 {}", e.getMessage());
//				throw new Exception(e.getMessage());
				throw new ErrMsgException(e.getMessage(), ErrorCode.EXCEL_FILE_ERROR);
			} finally {
				File delete = new File(oSourceFile);
                if (delete.exists()) {
                    delete.delete();
                }
			}
		} else {
			log.info("폴더생성 에러");
//			throw new Exception("폴더생성 에러");
			throw new ErrMsgException("폴더생성 에러", ErrorCode.FILE_DIR_ERROR);
		}
		return null;
	}


	/*
	 * Excel Data Load - 컬럼 정보 Map 으로 입력 후 List 형식 으로 출력
	 *
	 * ExcelFileType.getWorkbook 파일 확장자 타입을 구분
	*/
	public List<Map<String, Object>> excelFileUploadTyp2(ExcelReadOption readOpt) {

		InputStream  in;
		OutputStream out;
		String dir;
		String oHomeDir;
		Map<String, String> cols = readOpt.getCols();

		MultipartFile excelFile = readOpt.getExcelFile();

		String strFileName = excelFile.getOriginalFilename();
		String strExt = FilenameUtils.getExtension(strFileName);
		if (strExt != null) { strExt = strExt.toLowerCase(); }

		if (!Arrays.asList("xls","xlsm","xlsx").contains(strExt)) {
			throw new CustomBadRequestException(strFileName + " - 지원하지 않는 확장자 입니다.", ErrorCode.BAD_REQUEST);
		}

		if (SYSTEM_NAME.equals("local")) {
			oHomeDir = LOC_FASOO_PATH;
			dir = LOC_EXCEL_UPLOAD_PATH;
		} else {
			oHomeDir = SEV_FASOO_PATH;
			dir = SEV_UPLOAD_PATH;
		}

		String uid = UUID.randomUUID().toString();
		String oSourceFile = dir + uid + Objects.requireNonNull(strFileName).substring(strFileName.lastIndexOf("."));
		String oTargetFile = dir + uid + "_bak" + strFileName.substring(strFileName.lastIndexOf("."));

		File src = new File(dir);
		if (!src.exists()) { src.mkdirs(); }

		List<Map<String, Object>> list = new ArrayList<>();

		try {
			in = excelFile.getInputStream();
			out = Files.newOutputStream(Paths.get(oSourceFile));
			int bytesRead;
			byte[] buffer = new byte[8192];
			while ((bytesRead = in.read(buffer, 0, 8192)) != -1) {
				out.write(buffer, 0, bytesRead);
			}
			if(out != null) out.close();
			in.close();

			boolean bret = false;
			int iRet;

			try {
				WorkPackager fsa = new WorkPackager();
				iRet = fsa.GetFileType(oSourceFile);

				if (fsa.IsSupportFile(oHomeDir, FASOO_ID, oSourceFile)) {
					if (iRet == 103) {
						bret = fsa.DoExtract(oHomeDir, FASOO_ID, oSourceFile, oTargetFile);
						if (!bret) {
							log.info("오류코드 : " + fsa.getLastErrorNum() + " / 오류값 : " + fsa.getLastErrorStr());
							log.info("암호화문서 : " + fsa.getContainerFilePathName());
						}
					} else {
						oTargetFile = oSourceFile;
					}

					// src = new File(oTargetFile);
					Workbook wb = ExcelFileType.getWorkbook(oTargetFile);
					Sheet sheet;
					Row row;
					Cell cell;

					// int rows = sheet.getPhysicalNumberOfRows();
					// 첫번째 Sheet 고정
					sheet = wb.getSheetAt(0);
					int rows = sheet.getPhysicalNumberOfRows();
					int startRow = readOpt.getStartRow();

					// log.info("getPhysicalNumberOfRows : {}", sheet.getPhysicalNumberOfRows());
					// log.info("getLastRowNum : {}", sheet.getLastRowNum());

					for(int j=startRow; j < rows; j++) {
						row = sheet.getRow(j);

						if (row != null) {
							int cells = row.getLastCellNum();
							int startCol = 0;

							try {
								Map<String, Object> map = new HashMap<>();
								for (int k = startCol; k < cells; k++) {
									cell = row.getCell(k);
									map.put(
										cols.get(sheet.getRow(startRow-1).getCell(k).toString().trim())
									,	ExcelCellRef.getValue(cell, wb)
									);
								}

								// 해당 Row 데이터 존재 유무 체크 - 최소 4개 컬럼 이상
								if( map.entrySet().stream().filter(kv -> !kv.getValue().toString().isEmpty()).
										collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).
										size() > 3
								) {
									list.add(map);
								}
							} catch(Exception ex) {
								log.error("Create Map Err : {}", ex.getMessage());
								throw new ErrMsgException(ex.getMessage(), ErrorCode.EXCEL_UPLOAD_FAIL);
							}

						}
					}

				} else {
					if (fsa.getLastErrorNum() == -1) {
						log.error("EXCEL_DRM_NOT_FOUND : {}", fsa.getLastErrorStr());
						throw new ErrMsgException("user not set HomeDir or required property", ErrorCode.EXCEL_DRM_NOT_FOUND);
					} else {
						log.error("NOT_EXCEL_EXTENSION : {}", fsa.getLastErrorStr());
						throw new ErrMsgException("not supported source file extension", ErrorCode.NOT_EXCEL_EXTENSION);
					}
				}

			} catch (Exception e) {
				log.error("excelFileUploadTyp2 errMsg : {}", e.getMessage());
				throw new ErrMsgException(e.getMessage(), ErrorCode.EXCEL_UPLOAD_FAIL);
			}
		} catch (Exception e) {
			log.error("excelFileUploadTyp2 Error : {}", e.getMessage());
			throw new ErrMsgException(e.getMessage(), ErrorCode.EXCEL_FILE_ERROR);
		} finally {
			File delete = new File(oSourceFile);
			if (delete.exists()) { delete.delete(); }
		}

		return list;
	}


}
