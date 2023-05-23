package com.example.flywaydb.exceptions;

import com.example.flywaydb.model.dto.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionTranslator {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BusinessException.class)
    public ExceptionResponse handleBusinessException(BusinessException e) {
        return new ExceptionResponse("BUSINESS_EXCEPTION", e.getMessage());
    }
}
