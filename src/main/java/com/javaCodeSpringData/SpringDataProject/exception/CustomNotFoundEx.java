package com.javaCodeSpringData.SpringDataProject.exception;

public class CustomNotFoundEx extends RuntimeException{
    public CustomNotFoundEx(String message) {
        super(message);
    }
}
