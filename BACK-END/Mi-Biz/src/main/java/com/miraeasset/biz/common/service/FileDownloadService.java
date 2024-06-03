package com.miraeasset.biz.common.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;

@Service
public class FileDownloadService {

	public FileDownloadService() { 
		
	}

	public void download(HttpServletRequest request, 
			HttpServletResponse response, 
			String filepath, 
			String filename, 
			boolean inline) { 
		
		filepath = "/biz/WAS/nas/common/excel/down";
		//filepath = "D:/Java/file/download"; // local test
		
		System.out.println("FileDownloadService ---> filepath :=== [" + filepath +"]");
		System.out.println("FileDownloadService ---> filename :=== [" + filename +"]");
		
		File file = new File(filepath, filename);
		
        if(file == null || !file.exists()) {
            try {
            	System.out.println("file.exists() 404 :=== [" + file.exists() +"]");            	
            	response.sendError(404);
            } catch(IOException ioexception) {
            	//ioexception.printStackTrace();
            	System.out.println("IOException occurred");
            }
            return;
        }
        
        String s = request.getSession().getServletContext().getMimeType(file.getName());
        String brChk = request.getParameter("browsersChk");
        
        if(s == null || s.length() == 0){
        	response.setContentType("application/x-msdownload");
        }else if("safari".equals(brChk)){
        	response.setContentType("application/x-msdownload");
        }else{
        	response.setContentType(s);
        }
        
        String s1 = null;
        
        try {
            byte abyte[] = file.getName().getBytes("KSC5601");
            //s1 = new String(abyte, "8859_1");
            s1 = new String(abyte, "EUC-KR");
            System.out.println("FileDownloadService ---> s1 = new String(abyte, \"EUC-KR\"); :=== [" + s1 +"]");
        } catch(UnsupportedEncodingException unsupportedencodingexception) {
        	//unsupportedencodingexception.printStackTrace();
        	System.out.println("UnsupportedEncodingException occurred");
        }
        
        String s2 = "Content-Disposition";
        if(inline)
        	response.setHeader(s2, "inline;filename=\"" + s1 + "\"");
        else
        	response.setHeader(s2, "attachment;filename=\"" + s1 + "\"");
        long l = file.length();
                
        if("safari".equals(brChk)){
        	System.out.println("brChk : ["+brChk+"] s1 : ["+s1+"] fileMimeType : ["+s+"]");
        	response.setHeader("Pragma","public");
        	response.setHeader("Expires","0");
        	response.setHeader("Cache-Control","no-store,max-age=0,no-cache,must-revalidate");
        	response.setHeader("Cache-Control","post-check=0,pre-check=0,false");
        	response.setHeader("Cache-Control","private");        	
        	response.setHeader("Content-Transfer-Encoding","binary");
        }
        System.out.println("FileDownloadService ---> file.length() :=== [" + file.length() +"]");
        
        if(l >= 0L)
        	response.setContentLength((int)l);
        BufferedInputStream bufferedinputstream = null;
        BufferedOutputStream bufferedoutputstream = null;
        byte buffer[] = new byte[1024]; 
        
        System.out.println("FileDownloadService ---> file.downLoadStart()");
        
        try {
        	int i = 0;
        	response.flushBuffer();
            bufferedoutputstream = new BufferedOutputStream(response.getOutputStream());
            bufferedinputstream = new BufferedInputStream(new FileInputStream(file));
            while((i = bufferedinputstream.read(buffer)) != -1) { 
                bufferedoutputstream.write(buffer, 0, i);
            }
            System.out.println("FileDownloadService ---> file.downLoading()");
            
            response.flushBuffer();
        } catch(IOException ioexception1) {        	
        	//ioexception1.printStackTrace();        	
        	System.out.println("IOEncodingException occurred");
        } finally {
        	
            try {
                bufferedinputstream.close();
            } catch(IOException ioexception2) {
            	//ioexception2.printStackTrace();
            	System.out.println("IOEncodingException occurred");
            }
            try {
                bufferedoutputstream.close();
            } catch(IOException ioexception3) {
            	//ioexception3.printStackTrace();
            	System.out.println("IOException occurred");
            }
        }
        System.out.println("FileDownloadService ---> file.downLoaded()");
        return;
	}
	
}
