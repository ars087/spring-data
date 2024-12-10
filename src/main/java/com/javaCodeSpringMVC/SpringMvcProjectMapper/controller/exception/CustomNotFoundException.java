package com.javaCodeSpringMVC.SpringMvcProjectMapper.controller.exception;

public class CustomNotFoundException extends RuntimeException {

    public CustomNotFoundException(String message) {
        super(message);
    }
}
