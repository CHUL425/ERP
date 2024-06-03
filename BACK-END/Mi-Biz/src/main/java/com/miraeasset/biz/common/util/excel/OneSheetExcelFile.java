package com.miraeasset.biz.common.util.excel;

import java.util.List;

import com.miraeasset.biz.common.util.excel.resource.DataFormatDecider;

public final class OneSheetExcelFile<T> extends SXSSFExcelFile<T> {

	private static final int ROW_START_INDEX = 0;
	private static final int COLUMN_START_INDEX = 0;
	private int currentRowIndex = ROW_START_INDEX;
	
	public OneSheetExcelFile(Class<T> type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	
	public OneSheetExcelFile(List<T> data, Class<T> type) {
		super(data, type);
		// TODO Auto-generated constructor stub
	}
	
	public OneSheetExcelFile(List<T> data, Class<T> type, DataFormatDecider dataFormatDecider) {
		super(data, type, dataFormatDecider);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void validateData(List<T> data) {
		int maxRows = supplyExcelVersion.getMaxRows();
		if (data.size() > maxRows) {
			throw new IllegalArgumentException(String.format("This concreate ExcelFile does not support over %s rows", maxRows));
		}
	}
	
	@Override
	public void renderExcel(List<T> data) {
		// 1. Create sheet and renderHeader
		sheet  = wb.createSheet();
		renderHeadersWithNewSheet(sheet, currentRowIndex++, COLUMN_START_INDEX);
		
		if (data.isEmpty()) {
			return;
		}
		
		// 2. Render Body
		for (Object renderedData : data) {
			renderBody(renderedData, currentRowIndex++, COLUMN_START_INDEX);
		}
		
		/* 컬럼 사이즈 */
		for (int i=0; i < resource.getDataFieldName().size(); i++) {
			sheet.trackAllColumnsForAutoSizing();
			sheet.autoSizeColumn(i);
			sheet.setColumnWidth(i, Math.min(255 * 256, (sheet.getColumnWidth(i) + 1024)));
		}
	}
	
	@Override
	public void addRows(List<T> data) {
		renderBody(data, currentRowIndex++, COLUMN_START_INDEX);
	}

}
