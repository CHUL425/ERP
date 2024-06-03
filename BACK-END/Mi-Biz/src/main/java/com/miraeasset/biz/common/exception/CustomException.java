package com.miraeasset.biz.common.exception;

import com.miraeasset.biz.common.exception.vo.ErrorCode;

public class CustomException extends RuntimeException{
	
	private final ErrorCode errorCode;
	
	public CustomException(String message, ErrorCode errorCode){
		super(message);
		this.errorCode = errorCode;
	}
	
	public CustomException(ErrorCode errorCode){
		super(errorCode.getValue());
		this.errorCode = errorCode;
	}
	
	public ErrorCode getErrorCode(){
		return this.errorCode;
	}
	
}
