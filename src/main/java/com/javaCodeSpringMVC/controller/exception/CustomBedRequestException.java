package com.javaCodeSpringMVC.controller.exception;

public class CustomBedRequestException extends RuntimeException {
    public CustomBedRequestException(String message) {
        super(message);
    }
}
