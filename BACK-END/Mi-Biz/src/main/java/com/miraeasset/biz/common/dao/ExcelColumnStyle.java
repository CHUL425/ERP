package com.miraeasset.biz.common.dao;

import com.miraeasset.biz.common.util.excel.style.ExcelCellStyle;

public @interface ExcelColumnStyle {
	
	Class<? extends ExcelCellStyle> excelCellStyleClass();   
	
	String enumName() default "";
	
}
