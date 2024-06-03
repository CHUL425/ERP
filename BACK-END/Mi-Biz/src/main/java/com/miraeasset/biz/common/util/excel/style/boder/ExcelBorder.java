package com.miraeasset.biz.common.util.excel.style.boder;

import org.apache.poi.ss.usermodel.CellStyle;

public interface ExcelBorder {
		
	void applyTop(CellStyle cellStyle);
	
	void applyRight(CellStyle cellStyle);
	
	void applyBottom(CellStyle cellStyle);
	
	void applyLeft(CellStyle cellStyle);
	
}
