package com.example.demo.controller;

import com.example.demo.domain.constants.CustomerConstants;
import com.example.demo.domain.dto.Error;
import com.example.demo.domain.exception.CustomerException;
import com.example.demo.domain.response.CommonResponseDto;
import com.example.demo.util.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;

@ControllerAdvice
public class ExceptionController {

    @ResponseBody
    @ExceptionHandler(CustomerException.class)
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<CommonResponseDto> customerHandlerException(CustomerException ex){
        CommonResponseDto commonResponseDto = new CommonResponseDto();
        commonResponseDto.setStatus(CustomerConstants.FAILED);
        commonResponseDto.setErrors(Arrays.asList(formErrorMessage(ex)));
        return new ResponseEntity<>(commonResponseDto, HttpStatus.OK);
    }

    private Error formErrorMessage(CustomerException ex){
        Error error = new Error();
        ErrorMessage errorMessage = ErrorMessage.valueOf(ex.getMessage());
        error.setErrorCode(ex.getMessage());
        error.setErrorMessage(errorMessage.errorMessage());
        return error;
    }
}
