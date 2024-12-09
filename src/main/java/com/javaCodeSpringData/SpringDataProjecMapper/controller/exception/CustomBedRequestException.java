package com.javaCodeSpringData.SpringDataProjecMapper.controller.exception;

public class CustomBedRequestException extends RuntimeException {
    public CustomBedRequestException(String message) {
        super(message);
    }
}
