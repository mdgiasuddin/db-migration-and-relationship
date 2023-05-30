package com.example.flywaydb.exceptions;

import com.example.flywaydb.model.dto.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionTranslator {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BusinessException.class)
    public ExceptionResponse handleBusinessException(BusinessException e) {
        return new ExceptionResponse("BUSINESS_EXCEPTION", e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ExceptionResponse handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        return new ExceptionResponse("METHOD_ARGUMENT_TYPE_MISMATCH", e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> response = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(
                error -> response.put(error.getField(), error.getDefaultMessage())
        );

        return response;
    }

}
