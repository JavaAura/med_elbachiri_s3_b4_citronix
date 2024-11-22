package com.citronix.api.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.citronix.api.exception.ElementAlreadyExistException;
import com.citronix.api.exception.ElementDuplicationException;
import com.citronix.api.exception.ElementNotFoundException;


@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public Response handleBindException(BindException ex) {
        List<String> errors = new ArrayList<String>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            errors.add(error.getDefaultMessage());
        });
        log.info(ex.getMessage());
        return Response.builder()
            .code(HttpStatus.BAD_REQUEST.value())
            .status(HttpStatus.BAD_REQUEST.name())
            .errors(errors)
            .build();        
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ElementNotFoundException.class)
    public Response handElementNotFoundException(ElementNotFoundException ex) {
        log.info(ex.getMessage());
        return Response.builder()
            .code(HttpStatus.NOT_FOUND.value())
            .status(HttpStatus.NOT_FOUND.name())
            .errors(Arrays.asList(ex.getMessage()))
            .build();
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ElementDuplicationException.class)
    public Response handElementDuplicationException(ElementDuplicationException ex) {
        log.info(ex.getMessage());
        return Response.builder()
            .code(HttpStatus.BAD_REQUEST.value())
            .status(HttpStatus.BAD_REQUEST.name())
            .errors(Arrays.asList(ex.getMessage()))
            .build();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ElementAlreadyExistException.class)
    public Response handElementAlreadyExistException(ElementAlreadyExistException ex) {
        log.info(ex.getMessage());
        return Response.builder()
            .code(HttpStatus.BAD_REQUEST.value())
            .status(HttpStatus.BAD_REQUEST.name())
            .errors(Arrays.asList(ex.getMessage()))
            .build();
    }

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Response handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        log.info(ex.getMessage());
        return Response.builder()
            .code(HttpStatus.BAD_GATEWAY.value())
            .status(HttpStatus.BAD_GATEWAY.name())
            .errors(Arrays.asList(ex.getMessage()))
            .build();
    }

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(TransactionSystemException.class)
    public Response handleTransactionSystemException(TransactionSystemException ex) {
        log.info(ex.getMessage());
        return Response.builder()
            .code(HttpStatus.BAD_GATEWAY.value())
            .status(HttpStatus.BAD_GATEWAY.name())
            .errors(Arrays.asList(ex.getMessage()))
            .build();
    }

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Response handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        log.info(ex.getMessage());
        Pattern check = Pattern.compile("`com.citronix.api.entity.[\\w]+");
        Matcher checker = check.matcher(ex.getMessage());
        String error = ex.getMessage();
        while (checker.find()) {
            String[] tmp = checker.group(0).split("\\.");
            error = "This " + tmp[tmp.length -1] + " does not exist.";
        }

        return Response.builder()
            .code(HttpStatus.BAD_GATEWAY.value())
            .status(HttpStatus.BAD_GATEWAY.name())
            .errors(Arrays.asList(error))
            .build();
    }
    
}

