package com.miraeasset.biz.common.util.excel.style;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.miraeasset.biz.common.dao.ExcelColumnStyle;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultHeaderStyle {
	
	ExcelColumnStyle style();
}
