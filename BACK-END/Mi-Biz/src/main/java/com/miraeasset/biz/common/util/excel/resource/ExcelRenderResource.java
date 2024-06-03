package com.miraeasset.biz.common.util.excel.resource;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellStyle;

import com.miraeasset.biz.common.util.excel.style.PreCalculatedCellStyleMap;

public class ExcelRenderResource {
	
	private PreCalculatedCellStyleMap styleMap;
	
	// TODO dataFieldName -> excelHeaderName Map Abstraction;
	private Map<String, String> excelHeaderName;
	private List<String> dataFieldNames;
	
	public ExcelRenderResource(PreCalculatedCellStyleMap styleMap, Map<String, String> excelHeaderName, List<String> dataFieldNames) {
		this.styleMap = styleMap;
		this.excelHeaderName = excelHeaderName;
		this.dataFieldNames = dataFieldNames;
	}
	
	public CellStyle getCellStyle(String dataFieldName, ExcelRenderLocation excelRenderLocation) {
		// TODO Auto-generated method stub
		return styleMap.get(ExcelCellKey.of(dataFieldName, excelRenderLocation));
	}
	
	public String getExcelHeaderName(String dataFieldName) {
		return excelHeaderName.get(dataFieldName);
	}
	
	public List<String> getDataFieldName() {
		return dataFieldNames;
	}

}
