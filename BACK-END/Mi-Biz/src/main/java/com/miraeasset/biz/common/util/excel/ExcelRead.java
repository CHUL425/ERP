package com.miraeasset.biz.common.util.excel;

import static com.miraeasset.biz.common.util.excel.utils.SuperClassReflectionUtils.getAllFields;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelRead {
	
	public static List<Map<String, Object>> read(ExcelReadOption readOption) {
		/*
		 * 엑셀파일 자체
		 * 엑셀파일을 읽어 들인다
		 * ExcelFileType.getWorkbook 파일 확장자 타입을 구분해서 가져온다.
		 */
		Workbook wb = ExcelFileType.getWorkbook(readOption.getFilePath());
		Sheet sheet = null;
		Row row = null;
		Cell cell = null;
		
		// 엑셀 파일에서 시트개수를 가지고 온다.
		int sheetNum = wb.getNumberOfSheets();
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>(); 
		
		for(int i=0; i < sheetNum; i++) {
			
			// 엑셀 파일에서 n번째 시트를 가지고 온다.			
			sheet = wb.getSheetAt(i);
			// 시트에서 유효한(데이터가 있는) 로우 개수를 가져온다.
			int rows = sheet.getPhysicalNumberOfRows();
			// 시트에서 시작 지점의 로우를 가져온다.
			int startRow = readOption.getStartRow();
			
			for(int j=startRow; j < rows; j++) {
				row = sheet.getRow(j);
				
				if (row != null) {
					
//					int cells = row.getPhysicalNumberOfCells();
					// 시트에서 유효한(데이터가 있는) 행의 개수를 가져온다.
					int cells = row.getLastCellNum();
					// 시트에서 시작 지점의 행
					int startCol = 0;
					
					Map<String, Object> map = new HashMap<String, Object>();
					
					for(int k=startCol; k < cells; k++) {
						cell = row.getCell(k);
						
						if (cell == null) {
							continue;
						}
						
						// 헤더명
						String colName;
						colName = ExcelCellRef.getName(cell, k);
						// 로우 데이터
						String colValue;
						colValue = ExcelCellRef.getValue(cell, wb);
						
						map.put(colName, colValue);
						
					} // Cell
					list.add(map);
				}
			} // row
		}
		
		return list;
	}
}
