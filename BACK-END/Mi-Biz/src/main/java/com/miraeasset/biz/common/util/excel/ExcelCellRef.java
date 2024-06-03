package com.miraeasset.biz.common.util.excel;

import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;

import com.miraeasset.biz.common.util.DateUtil;

public class ExcelCellRef {
	
	/*
	 * Cell에 해당하는 Column Name을 가져온다
	 * 만약 Cell이 Null 이면 해당 cellIndex를 값으로 가져온다
	 * 
	 * @param cell
	 * @param cellIndex
	 * @return 
	 *   
	 * */
	
	public static String getName(Cell cell, int cellIndex) {
		int celNum = 0;
		
		if(cell != null) {
			celNum = cell.getColumnIndex();
		} else {
			celNum = cellIndex;
		}
		return CellReference.convertNumToColString(celNum);
	}
	
	
	public static String getValue(Cell cell, Workbook wb) {
		
		String value = "";
		FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator(); 
		
		if (cell == null) {
			value = "";
		}
		if (cell != null) {
			CellType cellType = cell.getCellTypeEnum();
			
			switch (cellType) {
				case NUMERIC :
//					if (DateUtil.isCellDateFormatted(cell)) {
					if (HSSFDateUtil.isCellDateFormatted(cell)) {
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
						value = formatter.format(cell.getDateCellValue());
					} else {
//						if ((cell.getNumericCellValue()+"").contains(".0")) {
//							int val = (int)cell.getNumericCellValue();
//							value = String.valueOf(val);
//						} else {
//							float val = (float)cell.getNumericCellValue();
//							value = String.valueOf(val);
//						}
						long val = (long)cell.getNumericCellValue();
						value = String.valueOf(val);
					}
					break;
				case STRING :
					value = cell.getStringCellValue();
					break;
				case ERROR :
					value = String.valueOf(cell.getErrorCellValue());
					break;
				case BLANK :
					value = "";
					break;
				case FORMULA :
					cellType = cell.getCachedFormulaResultTypeEnum();
					
					switch (cellType) {
					case NUMERIC:
						float val = (float)cell.getNumericCellValue();
						value = String.valueOf(val);
						break;
					case STRING:
						value = cell.getStringCellValue();
						break;
					default:
						break;
					}
					
//					if (evaluator.evaluateFormulaCellEnum(cell) == cellType.NUMERIC ) {
//						float val = (float)cell.getNumericCellValue();
//						value = String.valueOf(val);
//					} else if (evaluator.evaluateFormulaCellEnum(cell) == cellType.STRING) {
//						value = cell.getStringCellValue();
//					} 
					break;
				case BOOLEAN :
					value = String.valueOf(cell.getBooleanCellValue());
					break;
				default :
					value = cell.getStringCellValue();
			}
		}
		return value;
	}
	
}
