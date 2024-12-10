package com.javaCodeSpringMVC.SpringMvcProjectMapper.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerGlobal {


    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity<?> getDataCustomer(CustomNotFoundException customNotFoundException) {

        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(customNotFoundException);
    }

    @ExceptionHandler(CustomBedRequestException.class)
    public ResponseEntity<?> handleException(CustomBedRequestException customBedRequestException) {

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(customBedRequestException);
    }
}





