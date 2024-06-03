package com.miraeasset.biz.common.util.excel.style.boder;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CellStyle;

public final class DefaultExcelBoders implements ExcelBorders {
	
	private List<? extends ExcelBorder> borders;
	
	public DefaultExcelBoders(List<? extends ExcelBorder> borders) {
		validateBorders(borders);
		this.borders = borders;
	}
	
	public static DefaultExcelBoders newInstance(ExcelBorderStyle style) {
		List<DefaultExcelBoder> excelBorders = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			excelBorders.add(new DefaultExcelBoder(style));
		}
		return new DefaultExcelBoders(excelBorders);
	}
	
	private void validateBorders(List<? extends ExcelBorder> borders) {
		// TODO Auto-generated method stub
		if (borders.size() != 4) {
			throw new IllegalArgumentException("Should be initialized with TOP RIGHT LEFT BOTTOM borders");
		}
	}
	
	@Override
	public void apply(CellStyle cellStyle) {
		// TODO Auto-generated method stub
		borders.get(0).applyTop(cellStyle);
		borders.get(1).applyRight(cellStyle);
		borders.get(2).applyBottom(cellStyle);
		borders.get(3).applyLeft(cellStyle);
	}

}
