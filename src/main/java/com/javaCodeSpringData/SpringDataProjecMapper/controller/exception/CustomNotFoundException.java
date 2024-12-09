package com.javaCodeSpringData.SpringDataProjecMapper.controller.exception;

public class CustomNotFoundException extends RuntimeException {

    public CustomNotFoundException(String message) {
        super(message);
    }
}
