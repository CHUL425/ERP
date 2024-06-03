package com.miraeasset.biz.common.util.excel.style;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Workbook;

import com.miraeasset.biz.common.util.excel.resource.DataFormatDecider;
import com.miraeasset.biz.common.util.excel.resource.ExcelCellKey;

public class PreCalculatedCellStyleMap {
	
		private final DataFormatDecider dataFormatDecider;
		
		public PreCalculatedCellStyleMap(DataFormatDecider dataFormatDecider) {
			this.dataFormatDecider = dataFormatDecider;
		}
		
		private final Map<ExcelCellKey, CellStyle> cellStyleMap = new HashedMap<>();
		
		public void put(Class<?> fieldType, ExcelCellKey excelCellKey, ExcelCellStyle excelCellStyle, Workbook wb) {
			CellStyle cellStyle = wb.createCellStyle();
			DataFormat dataFormat = wb.createDataFormat();
			cellStyle.setDataFormat(dataFormatDecider.getDataFormat(dataFormat, fieldType));
			excelCellStyle.apply(cellStyle);
			cellStyleMap.put(excelCellKey, cellStyle);
		}
		
		public CellStyle get(ExcelCellKey excelCellKey) {
			return cellStyleMap.get(excelCellKey);
		}
		
		public boolean isEmpty() {
			return cellStyleMap.isEmpty();
		}
}
