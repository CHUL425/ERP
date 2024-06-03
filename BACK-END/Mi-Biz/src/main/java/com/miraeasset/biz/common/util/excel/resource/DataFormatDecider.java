package com.miraeasset.biz.common.util.excel.resource;

import org.apache.poi.ss.usermodel.DataFormat;

public interface DataFormatDecider {
	
	short getDataFormat(DataFormat dataFormat, Class<?> type);
	
}
