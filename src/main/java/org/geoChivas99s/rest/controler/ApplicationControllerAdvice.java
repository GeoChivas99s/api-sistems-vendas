package org.geoChivas99s.rest.controler;


import org.geoChivas99s.exception.BussinessRulesException;
import org.geoChivas99s.rest.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(BussinessRulesException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleBussinessRulesException(BussinessRulesException ex){
        String errorMessage = ex.getMessage();
        return new ApiErrors(errorMessage);
    }
}
