package com.miraeasset.biz.common.util.excel;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

public interface ExcelFile<T> {

	String createXlsEnc(String fileName) throws IOException;


	void write2(HttpServletResponse response, String fileName) throws IOException;

	
	void addRows(List<T> data);
}
