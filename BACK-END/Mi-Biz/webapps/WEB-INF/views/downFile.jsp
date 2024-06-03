<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%><%@ 
page import="com.miraeasset.biz.common.service.FileDownloadService"%><%

	String fileNm = request.getParameter("fileNm"); 
	FileDownloadService fileService = new FileDownloadService();
	fileService.download(request, response, "", fileNm, false);
	
	//fileService.download(request, response, "D:/Java/file/download", fileNm, false); // local test
%>