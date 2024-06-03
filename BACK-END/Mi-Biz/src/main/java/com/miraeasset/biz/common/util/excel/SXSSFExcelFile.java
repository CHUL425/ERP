package com.miraeasset.biz.common.util.excel;

import java.awt.Color;
import java.io.*;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasoo.adk.packager.WorkPackager;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.PropertyUtil;
import com.miraeasset.biz.common.util.excel.exception.ExcelInternalException;
import com.miraeasset.biz.common.util.excel.resource.DataFormatDecider;
import com.miraeasset.biz.common.util.excel.resource.DefaultDataFormatDecider;
import com.miraeasset.biz.common.util.excel.resource.ExcelRenderLocation;
import com.miraeasset.biz.common.util.excel.resource.ExcelRenderResource;
import com.miraeasset.biz.common.util.excel.resource.ExcelRenderResourceFactory;

import static com.miraeasset.biz.common.util.excel.utils.SuperClassReflectionUtils.getField;

public abstract class SXSSFExcelFile<T> implements ExcelFile<T> {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	protected static final SpreadsheetVersion supplyExcelVersion = SpreadsheetVersion.EXCEL2007;
	
	protected SXSSFWorkbook wb;
	protected SXSSFSheet sheet;
	protected ExcelRenderResource resource;
	
	/**
	 * SXSSFExcelFile
	 * @param type Class type to be rendered
	 */
	public SXSSFExcelFile(Class<T> type) {
		this(Collections.emptyList(), type, new DefaultDataFormatDecider());
	}
	
	/**
	 * SXSSFExcelFile
	 * @param data List Data to render excel file. data should have at least on @ExcelColumninfo on fields
	 * @param type Class type to be rendered
	 */
	public SXSSFExcelFile(List<T> data, Class<T> type) {
		this(data, type, new DefaultDataFormatDecider());
	}
	
	/**
	 * SXSSFExcelFile
	 * @param data List Data to render excel file. data should have at least on @ExcelColumninfo on fields
	 * @param type Class type to be rendered
	 * @param dataFormatDecider Custom DataFormatDecider
	 */
	public SXSSFExcelFile(List<T> data, Class<T> type, DataFormatDecider dataFormatDecider) {
		// TODO Auto-generated constructor stub
		validateData(data);
		this.wb = new SXSSFWorkbook();
		this.wb.setCompressTempFiles(true);
		this.resource = ExcelRenderResourceFactory.prepareRenderResource(type, wb, dataFormatDecider);
		renderExcel(data);
	}

	protected void validateData(List<T> data) {}
	
	protected abstract void renderExcel(List<T> data);
	
	protected void renderHeadersWithNewSheet(Sheet sheet, int rowIndex, int columnStartIndex) {
		Row row = sheet.createRow(rowIndex);
		int columnIndex = columnStartIndex;
		
		/* 엑셀 헤더스타일 설정 */
		for (String dataFieldName : resource.getDataFieldName()) {
			Cell cell = row.createCell(columnIndex++);
			cell.setCellStyle(resource.getCellStyle(dataFieldName, ExcelRenderLocation.HEADER));
			cell.setCellValue(resource.getExcelHeaderName(dataFieldName));
		}
	}
	
	protected void renderBody(Object data, int rowIndex, int columnStartIndex) {
		Row row = sheet.createRow(rowIndex);
		int columnIndex = columnStartIndex;
		
		/* 엑셀 바디스타일 설정 */
		for (String dataFieldName : resource.getDataFieldName()) {
			Cell cell = row.createCell(columnIndex++);
			try {
				Field field = getField(data.getClass(), (dataFieldName));
				field.setAccessible(true);
				cell.setCellStyle(resource.getCellStyle(dataFieldName, ExcelRenderLocation.BODY));
				
				/* 자동 줄바꿈 처리 */
				cell.getCellStyle().setWrapText(true);
				/* 줄바꿈 처리시 자동 로우 놓이 변경 */
				row.setHeight((short)-1);
				
				/* Header컬럼이 Dt가 존재하면 format */
				Object cellValue = "";
				if(field.getName() != null && field.getName().contains("Dt")) {
					cellValue = formatDate(field.get(data), cellValue);
				} else if (field.getName() != null && field.getName().contains("Ym")) {
					cellValue = formatDate(field.get(data), cellValue);
				} else {
					cellValue = field.get(data);
				}
				
				renderCellValue(cell, cellValue);
			} catch (Exception e) {
				// TODO: handle exception
				throw new ExcelInternalException(e.getMessage(), e);
			}
		}
	}
	
	private Object formatDate(Object object, Object cellValue) {
		
			StringBuffer sb = new StringBuffer();
			sb.append(object);
			if(sb.length() == 8) {
				sb.insert(6, "-");
				sb.insert(4, "-");
				cellValue = sb;
			} else if (sb.length() == 6) {
				sb.insert(4, "-");
				cellValue = sb;
			} else {
				cellValue = object;
			}
		return cellValue;
	}
	
	private void renderCellValue(Cell cell, Object cellValue) {
		if (cellValue instanceof Number) {
			Number numberValue = (Number) cellValue;
			cell.setCellValue(numberValue.doubleValue());
			return;
		}
		cell.setCellValue(cellValue == null ? "" : cellValue.toString());
	}
	
	private void applyCellStyle(CellStyle cellStyle, Color color) {
		
		XSSFCellStyle xssfCellStyle = (XSSFCellStyle) cellStyle;
		
		/* 정렬 */
		xssfCellStyle.setAlignment(HorizontalAlignment.CENTER);
		xssfCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		
		/* 배경 색상 : Color 사용 */
		xssfCellStyle.setFillForegroundColor(new XSSFColor(color));
		xssfCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		/* 배경 색상 : XSSFCellStyle 사용 */
//		Color bodyColor = new Color();
//		xssfCellStyle.setBorderColor(BorderSide.BOTTOM, new XSSFColor(bodyColor));
//		xssfCellStyle.setBorderColor(BorderSide.TOP, new XSSFColor(bodyColor));
//		xssfCellStyle.setBorderColor(BorderSide.LEFT, new XSSFColor(bodyColor));
//		xssfCellStyle.setBorderColor(BorderSide.RIGHT, new XSSFColor(bodyColor));
		
		/* 테두리 선 (좌, 우, 위, 아래) */
		xssfCellStyle.setBorderLeft(BorderStyle.THIN);
		xssfCellStyle.setBorderRight(BorderStyle.THIN);
		xssfCellStyle.setBorderTop(BorderStyle.THIN);
		xssfCellStyle.setBorderBottom(BorderStyle.THIN);
	}


	/**
	 * 엑셀 파일 생성 - 서버에 파일 저장 후 해당 경로 리턴, 엑셀 파일은 일자로 암호화
	 */
	public String createXlsEnc(String fileName) throws IOException {
		String savePath;
		String saveFilePath = "";
		String dt = DateUtil.getDate();

		try {

			if (PropertyUtil.getProperty("SYSTEM_NAME").equals("local")) {
				savePath = PropertyUtil.getProperty("LOC_DOWNLOAD_PATH");
			}
			else{
				savePath = PropertyUtil.getProperty("SEV_DOWNLOAD_PATH");
			}
			savePath = savePath + dt + "/";
			File dir = new File(savePath);
			if (!dir.exists()) { dir.mkdirs(); }

			saveFilePath = savePath + fileName;

			// 엑셀 파일 암호화 추가
			POIFSFileSystem PS = new POIFSFileSystem();
			EncryptionInfo EI = new EncryptionInfo(EncryptionMode.standard);
			Encryptor enc = EI.getEncryptor();
			enc.confirmPassword(dt);

			wb.setForceFormulaRecalculation(true);

			try{
				wb.write(enc.getDataStream(PS));
				wb.close();
			}catch (Exception ex){
				log.error(ex.getMessage());
			}

			FileOutputStream fileOut = new FileOutputStream(saveFilePath);
			PS.writeFilesystem(fileOut);
			fileOut.close();
			PS.close();
		} catch(Exception ignored) {
		}

		return saveFilePath;
	}

	
	public void write2(HttpServletResponse response, String fileName) throws IOException {
		
		String oHomeDir = "";
		String oServerID = PropertyUtil.getProperty("FASOO_ID");
		String securityLevel = PropertyUtil.getProperty("SECURITY_LEVEL");
		String uuidNm = UUID.randomUUID().toString();
		
		String dateFolderNm = DateUtil.getDate();
		String pathContents = PropertyUtil.getProperty("SEV_UPLOAD_PATH");
		String pathTarget = PropertyUtil.getProperty("SEV_DOWNLOAD_PATH");
		String localpathTarget = PropertyUtil.getProperty("LOC_DOWNLOAD_PATH")+File.separator+dateFolderNm;
		String savePath = "";
		
		String oSourceFile = pathContents+File.separator+uuidNm+".xlsx";
		String oTargetFile = pathTarget+File.separator+uuidNm+".xlsx";
		if (PropertyUtil.getProperty("SYSTEM_NAME").equals("local")) {
			File dir3 = new File(localpathTarget);
			if (!dir3.exists()) {
				dir3.mkdirs();
			}
			savePath=localpathTarget+"/"+uuidNm+".xlsx";
			oSourceFile=savePath;
        	oTargetFile=savePath;
        	
        	oHomeDir = PropertyUtil.getProperty("LOC_FASOO_PATH");
        	
		} else {
			File dir1 = new File(pathContents);
			if (!dir1.exists()) {
				dir1.mkdirs();
			}
			
			File dir2 = new File(pathTarget);
			if (!dir2.exists()) {
				dir2.mkdirs();
			}
			
			oHomeDir = PropertyUtil.getProperty("SEV_FASOO_PATH");
			
			savePath = oSourceFile; 
		}
		
		wb.setForceFormulaRecalculation(true);
		FileOutputStream fileOut = new FileOutputStream(savePath);
		wb.write(fileOut);
		fileOut.close();
		
		try {
			if (!PropertyUtil.getProperty("SYSTEM_NAME").equals("local")) {
				
				log.info("SYSTEM_NAME = {}, home = {}, sour = {}, tar = {}", PropertyUtil.getProperty("SYSTEM_NAME"), oHomeDir, oSourceFile, oTargetFile);
				
				WorkPackager oWorkPackager = new WorkPackager();
				oWorkPackager.setOverWriteFlag(false);
				
				boolean bret = oWorkPackager.DoPackagingFsn2(oHomeDir,oServerID,oSourceFile,oTargetFile, 
						uuidNm+".xlsx", 
						"admin", 
						"관리자", 
						"test", "아무개", "001", "팀_1",
						"test", "아무개", "001", "팀_1", securityLevel);
				
				if (!bret) {
					log.info("암호화 중 오류입니다.");
					log.info(" 오류 정보..");
					log.info(" ["+ oWorkPackager.getLastErrorNum()+"] "+oWorkPackager.getLastErrorStr());
					//throw new Exception("암호시 문제가 발생하였습니다.!");
					
					File delFile=new File(oSourceFile);
					if(delFile.exists()) {
						delFile.delete();
					}
					
					//암호화가 안되면 무조건 파일 다운 못받음...........
					throw new Exception("암호시 문제가 발생하였습니다.!");
				}
			}
			
			DateUtil.setResponseDownload(response, fileName, oTargetFile);
			
			File delFile=new File(oSourceFile);   //생성한 엑셀 파일 삭제
        	if(delFile.exists()) {
        		delFile.delete();
        	}
		} catch (Exception e) {
			// TODO: handle exception
			File delFile=new File(oSourceFile); //생성한 엑셀 파일 삭제
        	if(delFile.exists()) {
        		delFile.delete();
        	}
			e.printStackTrace();
		}
		
	}
}
