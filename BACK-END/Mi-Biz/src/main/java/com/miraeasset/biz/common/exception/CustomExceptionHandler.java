package com.miraeasset.biz.common.exception;

import com.google.gson.JsonParseException;
import com.miraeasset.biz.common.exception.vo.CommonErrorResponse;
import com.miraeasset.biz.common.util.CommonUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomBadRequestException.class)
    public CommonErrorResponse handleCustomBadRequestException(CustomBadRequestException e) {
        CommonErrorResponse response = new CommonErrorResponse();
        response.setMessage(e.getMessage());
        // response.setCode((e.getErrorCode().toString()));
        response.setCode((e.getErrorCode().getKey()));
        response.setStatus(e.getErrorCode().getStatus());
        response.setDetail(e.getMessage());
        return response;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public CommonErrorResponse handleJsonParseException(RuntimeException e) {
        CommonErrorResponse response = new CommonErrorResponse();
        e.printStackTrace();
        response.setMessage(e.getClass() + ":" + e.getMessage());
        response.setCode("400");
        response.setDetail("HTTP 메시지를 읽을 수 없어요. 화면명을 경영시스템팀에 알려주시면 IT 담당자가 조치할게요.");
        return response;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public CommonErrorResponse handleRuntimeException(RuntimeException e) {
        CommonErrorResponse response = new CommonErrorResponse();
         e.printStackTrace();
        String strErr = e.getMessage();
        if(strErr == null || strErr.equals("null")){
            response.setMessage(e.getClass() + ":" + strErr);
        }
        else if( strErr.contains("SQLSyntaxError") || strErr.contains("ORA-") || strErr.contains("SQLException") ){
            response.setMessage(CommonUtil.getCauseFirst(e));
        }
        else {
            response.setMessage(strErr);
        }
        response.setCode("400");
        response.setDetail("오류가 발생했어요. 화면명을 경영시스템팀에 알려주시면 IT 담당자가 조치할게요.");

        return response;
    }
}
