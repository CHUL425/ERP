package com.miraeasset.biz.common.util.excel;

import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExcelReadOption {
	
	/* 파일경로 */
	private String filePath; 
	/* 추출 컬럼명 */
	private List<String> outputColumns;
	/* 시작행 번호*/
	private int startRow;
	/* 시트번호 */
	private int sheetNum;

	/* 컬럼 리스트 */
	private Map<String, String> cols;

	/* 엑셀 파일 */
	private MultipartFile excelFile;

	public MultipartFile getExcelFile() { return excelFile; } public void setExcelFile(MultipartFile excelFile) { this.excelFile = excelFile; }

	public Map<String, String> getCols() { return cols; } public void setCols(Map<String, String> cols) { this.cols = cols; }


	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public List<String> getOutputColumns() {
		
		List<String> temp = new ArrayList<String>();
		temp.addAll(outputColumns);
		
		return temp;
	}

	public void setOutputColumns(List<String> outputColumns) {
		
		List<String> temp = new ArrayList<String>();
		temp.addAll(outputColumns);
		
		this.outputColumns = temp;
	}
	public void setOutputColumns(String...outputColumns) {
		if (this.outputColumns == null) {
			this.outputColumns = new ArrayList<String>();
		}
		
		for(String outputColumn : outputColumns) {
			this.outputColumns.add(outputColumn);
		}
		
	}

	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getSheetNum() {
		return sheetNum;
	}
	public void setSheetNum(int sheetNum) {
		this.sheetNum = sheetNum;
	}
	
}
