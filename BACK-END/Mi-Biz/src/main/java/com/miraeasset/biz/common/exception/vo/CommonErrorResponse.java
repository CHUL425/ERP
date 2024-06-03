package com.miraeasset.biz.common.exception.vo;

import org.springframework.stereotype.Component;

@Component
public class CommonErrorResponse {
	
	private String message;
	private String code;
	private int status;
	private String detail;
	
	public CommonErrorResponse(){
		
	}
	
	public CommonErrorResponse(ErrorCode code) {
		this.message 	= code.getValue();
		this.code 		= code.getKey();
		this.status 	= code.getStatus();
		this.detail 	= code.getDetail();
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}

	public static CommonErrorResponse of(ErrorCode code){
		return new CommonErrorResponse(code);
	}
}
