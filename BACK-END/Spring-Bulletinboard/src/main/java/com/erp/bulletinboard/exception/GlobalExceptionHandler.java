package com.erp.bulletinboard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.context.request.WebRequest;

import lombok.Getter;
import lombok.Setter;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 예외 처리 메서드 예제
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 특정 예외 처리 메서드
    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceAccessException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // ErrorResponse 클래스 (응답 본문을 위한 클래스)
    @Getter
    @Setter
    static class ErrorResponse {
        private int    statusCode ;
        private String message    ;
        private String description;

        public ErrorResponse(int statusCode, String message, String description) {
            this.statusCode  = statusCode ;
            this.message     = message    ;
            this.description = description;
        }
    }
}