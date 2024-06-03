package com.miraeasset.biz.common.dao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.miraeasset.biz.common.util.excel.style.NoExcelCellStyle;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelColumnInfo {
	
	String notes() default "";
	
	ExcelColumnStyle headerStyle() default @ExcelColumnStyle(excelCellStyleClass = NoExcelCellStyle.class);
	ExcelColumnStyle bodyStyle() default @ExcelColumnStyle(excelCellStyleClass = NoExcelCellStyle.class);
}
