package com.miraeasset.biz.common.util.excel.style.boder;

import org.apache.poi.ss.usermodel.CellStyle;

public final class DefaultExcelBoder implements ExcelBorder {
	
	private ExcelBorderStyle borderStyle;
	
	public DefaultExcelBoder(ExcelBorderStyle borderStyle) {
		this.borderStyle = borderStyle;
	}
	
	
	@Override
	public void applyTop(CellStyle cellStyle) {
		// TODO Auto-generated method stub
		cellStyle.setBorderTop(borderStyle.getStyle());
	}

	@Override
	public void applyRight(CellStyle cellStyle) {
		// TODO Auto-generated method stub
		cellStyle.setBorderRight(borderStyle.getStyle());
	}

	@Override
	public void applyBottom(CellStyle cellStyle) {
		// TODO Auto-generated method stub
		cellStyle.setBorderBottom(borderStyle.getStyle());
	}

	@Override
	public void applyLeft(CellStyle cellStyle) {
		// TODO Auto-generated method stub
		cellStyle.setBorderLeft(borderStyle.getStyle());
	}
	
	
}
