package com.javaCodeSpringMVC.SpringMvcProjectMapper.controller.exception;

public class CustomBedRequestException extends RuntimeException {
    public CustomBedRequestException(String message) {
        super(message);
    }
}
