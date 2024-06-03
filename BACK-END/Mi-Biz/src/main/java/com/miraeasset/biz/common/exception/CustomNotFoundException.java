package com.miraeasset.biz.common.exception;

import com.miraeasset.biz.common.exception.vo.ErrorCode;

public class CustomNotFoundException extends CustomException{

	public CustomNotFoundException(ErrorCode errorCode) {
		super(errorCode);
	}
	
	public CustomNotFoundException(String message, ErrorCode errorCode){
		super(message,errorCode);
	}
}