package com.miraeasset.biz.common.exception;

import com.miraeasset.biz.common.exception.vo.ErrorCode;

public class CustomBadRequestException extends CustomException{

	public CustomBadRequestException(String message, ErrorCode errorCode){
		super(message,errorCode);
	}
}
