package com.miraeasset.biz.common.util.excel.resource;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;

import com.miraeasset.biz.common.dao.ExcelColumnInfo;
import com.miraeasset.biz.common.dao.ExcelColumnStyle;
import com.miraeasset.biz.common.util.excel.exception.InvalidExcelCellStyleException;
import com.miraeasset.biz.common.util.excel.style.DefaultBodyStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultHeaderStyle;
import com.miraeasset.biz.common.util.excel.style.ExcelCellStyle;
import com.miraeasset.biz.common.util.excel.style.NoExcelCellStyle;
import com.miraeasset.biz.common.util.excel.style.PreCalculatedCellStyleMap;

import static com.miraeasset.biz.common.util.excel.utils.SuperClassReflectionUtils.getAllFields;
import static com.miraeasset.biz.common.util.excel.utils.SuperClassReflectionUtils.getAnnotation;

public final class ExcelRenderResourceFactory {
	
	public static ExcelRenderResource prepareRenderResource(Class<?> type, Workbook wb, DataFormatDecider dataFormatDecider) {
		
		PreCalculatedCellStyleMap styleMap = new PreCalculatedCellStyleMap(dataFormatDecider);
		Map<String, String> headerNameMap = new LinkedHashMap<>();
		List<String> fieldNameList = new ArrayList<String>();
		
		ExcelColumnStyle classDefinedHeaderStyle = getHeaderExcelColumnStyle(type);
		ExcelColumnStyle classDefinedBodyStyle = getBodyExcelColumnStyle(type);
		
		for (Field field : getAllFields(type)) {
			if (field.isAnnotationPresent(ExcelColumnInfo.class)) {
				ExcelColumnInfo annotation = field.getAnnotation(ExcelColumnInfo.class);
				styleMap.put(String.class, ExcelCellKey.of(field.getName(), ExcelRenderLocation.HEADER),
							 getCellStyle(decideAppliedStyleAnnotation(classDefinedHeaderStyle, annotation.headerStyle())), wb);
				Class<?> fieldType = field.getType();
				styleMap.put(fieldType, ExcelCellKey.of(field.getName(), ExcelRenderLocation.BODY),
							 getCellStyle(decideAppliedStyleAnnotation(classDefinedBodyStyle, annotation.bodyStyle())), wb);
				fieldNameList.add(field.getName());
				headerNameMap.put(field.getName(), annotation.notes());
			}
		}
		
		if (styleMap.isEmpty()) {
			
		}
		return new ExcelRenderResource(styleMap, headerNameMap, fieldNameList);
	}
	

	private static ExcelColumnStyle getHeaderExcelColumnStyle(Class<?> cls) {
		Annotation annotation = getAnnotation(cls, DefaultHeaderStyle.class);
		if (annotation == null) {
			return null;
		}
		return ((DefaultHeaderStyle) annotation).style(); 
	}
	private static ExcelColumnStyle getBodyExcelColumnStyle(Class<?> cls) {
		Annotation annotation = getAnnotation(cls, DefaultBodyStyle.class);
		if (annotation == null) {
			return null;
		}
		return ((DefaultBodyStyle) annotation).style();
	}
	
	private static ExcelColumnStyle decideAppliedStyleAnnotation(ExcelColumnStyle classAnnotation, ExcelColumnStyle fieldAnnotation) {
		if (fieldAnnotation.excelCellStyleClass().equals(NoExcelCellStyle.class) && classAnnotation != null) {
			return classAnnotation;
		}
		return fieldAnnotation;
	}
	
	private static ExcelCellStyle getCellStyle(ExcelColumnStyle excelColumnStyle) {
		Class<? extends ExcelCellStyle> excelCellStyleClass = excelColumnStyle.excelCellStyleClass();
		// 1. Case of Enum
		if (excelCellStyleClass.isEnum()) {
			String enumName = excelColumnStyle.enumName();
			return findExcelCellStyle(excelCellStyleClass, enumName);
		}
		
		// 2. Case of Class
		try {
			return excelCellStyleClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO: handle exception
			throw new InvalidExcelCellStyleException(e.getMessage(), e);
			
		}
	}
	
	@SuppressWarnings("unchecked")
	private static ExcelCellStyle findExcelCellStyle(Class<?> excelCellStyles, String enumName) {
		try {
			return (ExcelCellStyle) Enum.valueOf((Class<Enum>) excelCellStyles, enumName);
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new InvalidExcelCellStyleException("enumName must not be null", e);
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			throw new InvalidExcelCellStyleException(String.format("Enum %s does not name %s", excelCellStyles.getName(), enumName), e);
		}
	}
}
