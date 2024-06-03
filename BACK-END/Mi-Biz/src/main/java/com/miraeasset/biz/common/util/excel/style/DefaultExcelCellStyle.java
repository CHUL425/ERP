package com.miraeasset.biz.common.util.excel.style;

import org.apache.poi.ss.usermodel.CellStyle;

import com.miraeasset.biz.common.util.excel.style.align.DefaultExcelAlign;
import com.miraeasset.biz.common.util.excel.style.align.ExcelAlign;
import com.miraeasset.biz.common.util.excel.style.boder.DefaultExcelBoders;
import com.miraeasset.biz.common.util.excel.style.boder.ExcelBorderStyle;
import com.miraeasset.biz.common.util.excel.style.color.DefaultExcelColor;
import com.miraeasset.biz.common.util.excel.style.color.ExcelColor;

public enum DefaultExcelCellStyle implements ExcelCellStyle {
	
	GREY_HEADER(DefaultExcelColor.rgb(230, 230, 230), DefaultExcelBoders.newInstance(ExcelBorderStyle.THIN), DefaultExcelAlign.CENTER_CENTER),
	BLUE_HEADER(DefaultExcelColor.rgb(223, 235, 246), DefaultExcelBoders.newInstance(ExcelBorderStyle.THIN), DefaultExcelAlign.CENTER_CENTER),
	BODY(DefaultExcelColor.rgb(255, 255, 255), DefaultExcelBoders.newInstance(ExcelBorderStyle.THIN), DefaultExcelAlign.CENTER_CENTER),
	CENTER(DefaultExcelColor.rgb(255, 255, 255), DefaultExcelBoders.newInstance(ExcelBorderStyle.THIN), DefaultExcelAlign.CENTER_CENTER),
	LEFT(DefaultExcelColor.rgb(255, 255, 255), DefaultExcelBoders.newInstance(ExcelBorderStyle.THIN), DefaultExcelAlign.LEFT_CENTER),
	RIGHT(DefaultExcelColor.rgb(255, 255, 255), DefaultExcelBoders.newInstance(ExcelBorderStyle.THIN), DefaultExcelAlign.RIGHT_CENTER, Short.valueOf("3")), // "#,##0"
	DECIMAL2(DefaultExcelColor.rgb(255, 255, 255), DefaultExcelBoders.newInstance(ExcelBorderStyle.THIN), DefaultExcelAlign.RIGHT_CENTER, Short.valueOf("2")); // "0.00"
	
	private final ExcelColor backgroundColor;
	/**
	 * like CSS margin or padding rule.
	 * List<DefaultExcelBoder> represents rgb TOP RIGHT BOTTOM LEFT
	 */
	private final DefaultExcelBoders borders;
	private final ExcelAlign align;

	// [20231122] 셀 스타일 추가
	private final Short fmt; // poi.apache.org/apidocs/dev/org/apache/poi/ss/usermodel/BuiltinFormats.html 참고
	
	DefaultExcelCellStyle(ExcelColor backgroundColor, DefaultExcelBoders borders, ExcelAlign align) {
		this.backgroundColor = backgroundColor;
		this.borders = borders;
		this.align = align;
		this.fmt = 0; // General
	}

	DefaultExcelCellStyle(ExcelColor backgroundColor, DefaultExcelBoders borders, DefaultExcelAlign align, Short fmt) {
		this.backgroundColor = backgroundColor;
		this.borders = borders;
		this.align = align;
		this.fmt = fmt;
	}

	@Override
	public void apply(CellStyle cellStyle) {
		// TODO Auto-generated method stub
		backgroundColor.applyForeground(cellStyle);
		borders.apply(cellStyle);
		align.apply(cellStyle);
		cellStyle.setDataFormat(fmt);
	}

}
