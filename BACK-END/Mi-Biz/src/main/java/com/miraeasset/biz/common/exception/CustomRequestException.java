package com.miraeasset.biz.common.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.miraeasset.biz.common.exception.vo.CommonErrorResponse;
import com.miraeasset.biz.common.exception.vo.ErrorCode;

import java.sql.SQLException;

public class CustomRequestException {
	
	@ExceptionHandler(value = CustomNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected ResponseEntity<CommonErrorResponse> handleCustomNotFoundException(CustomNotFoundException e){
        CommonErrorResponse response = CommonErrorResponse.of(ErrorCode.RESOURCE_NOT_FOUND);
        response.setDetail(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NoSessionException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    protected ResponseEntity<CommonErrorResponse> handleNoSessionException(CustomNotFoundException e){
        CommonErrorResponse response = CommonErrorResponse.of(ErrorCode.UNAUTHORIZED);
        response.setCode(e.getErrorCode().getKey());
        response.setDetail(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = CustomBadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected ResponseEntity<CommonErrorResponse> handleCustomBadRequestException(CustomBadRequestException e){
        if(e.getErrorCode().getKey().equals("C005")){
            CommonErrorResponse response = CommonErrorResponse.of(ErrorCode.UNAUTHORIZED);
            response.setDetail(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
        else{
            String strErr = e.getMessage();
            if(strErr == null || strErr.equals("null")){
                strErr = e.getClass() + " : null";
            }
            else if( strErr.contains("SQLSyntaxError") || strErr.contains("ORA-") ){
                strErr = strErr.substring(strErr.indexOf("SQLSyntaxErrorException"));
                strErr = strErr.substring(0, strErr.indexOf("###"));
            }
            else if( strErr.contains("SQLException") ){
                strErr = strErr.substring(strErr.indexOf("SQLException"));
                strErr = strErr.substring(0, strErr.indexOf("###"));
            }

            CommonErrorResponse response = CommonErrorResponse.of(ErrorCode.BAD_REQUEST);
            response.setDetail(strErr);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    
    @ExceptionHandler(value = ErrMsgException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseEntity<CommonErrorResponse> handleCustomBadRequestException(ErrMsgException e){
        CommonErrorResponse response = CommonErrorResponse.of(e.getErrorCode());
        response.setDetail(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
