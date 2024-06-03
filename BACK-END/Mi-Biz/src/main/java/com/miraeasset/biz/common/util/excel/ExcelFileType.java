package com.miraeasset.biz.common.util.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.miraeasset.biz.common.util.excel.exception.ExcelException;

public class ExcelFileType {
	
	/*
	 * 엑셀파일 확장자 체크 Workbook 객체에 리턴
	 * XSL, XLSX
	 *
	 * @param filePath
	 * @return
	 * 
	 * */
	public static Workbook getWorkbook(String filePath) {
		
		/*
		 * FileInputStream
		 * 파일의 경로에있는 파일을 읽어 byte로 가져옴
		 * 
		 * 파일이 존재하지 않을경우
		 * RuntimeException처리
		 * 
		 * */
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			throw new RuntimeException(e.getMessage(), e);
		}
		
		Workbook wb = null;
		
		/*
		 * 엑셀 확장자별 Workbook 셋팅
		 * */
		if (filePath.toUpperCase().endsWith(".XLS")) {
			try {
				wb = new HSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO: handle exception
				throw new RuntimeException(e.getMessage(), e);
			}
		}
		else if (filePath.toUpperCase().endsWith(".XLSX")) {
			try {
				wb = new XSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO: handle exception
				throw new RuntimeException(e.getMessage(), e);
			}
		}
		if (fis != null) {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO: handle exception
				throw new ExcelException("예외상황 발생", e); 
			}
		}
		
		return wb;
	}
	
}
