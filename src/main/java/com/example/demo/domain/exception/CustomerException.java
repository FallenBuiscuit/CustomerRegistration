package com.example.demo.domain.exception;

public class CustomerException extends RuntimeException{

    public CustomerException(String errorCode){
        super(errorCode);
    }
}
