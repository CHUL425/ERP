package com.miraeasset.biz.common.exception;

import com.miraeasset.biz.common.exception.vo.ErrorCode;

public class ErrMsgException extends CustomException {
	
	public ErrMsgException(String message, ErrorCode errorCode){
		super(message,errorCode);
	}
}
