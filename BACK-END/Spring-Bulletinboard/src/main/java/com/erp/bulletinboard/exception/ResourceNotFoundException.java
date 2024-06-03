package com.erp.bulletinboard.exception;

public class ResourceNotFoundException extends RuntimeException {
   public ResourceNotFoundException(String message) {
        super(message);
    }
}