package com.example.exception;

import org.springframework.http.HttpStatus;


public class BadRequestException extends RuntimeException {
    BadRequestException(String errorMessage, Throwable err){
        super(errorMessage, err);
    }
}