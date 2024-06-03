package com.miraeasset.biz.common.exception;

import com.miraeasset.biz.common.exception.vo.ErrorCode;

public class NoSessionException extends CustomException{

	public NoSessionException(ErrorCode errorCode) {
		super(errorCode);
	}
	
	public NoSessionException(String message, ErrorCode errorCode){
		super(message,errorCode);
	}
}

