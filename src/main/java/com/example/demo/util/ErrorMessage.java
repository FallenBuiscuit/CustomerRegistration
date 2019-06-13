package com.example.demo.util;

public enum ErrorMessage {

    C107109001("Customer is not Registered."),
    C107109002("There is no Registered Customers."),
    C107109003("Id field is mandatory."),
    C107109004("Please place a customer to be registered")
    ;
    private String errorMessage;

    ErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String errorMessage(){
        return errorMessage;
    }
}
