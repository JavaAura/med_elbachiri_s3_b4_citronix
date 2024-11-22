package com.citronix.api.exception;

public class ElementAlreadyExistException extends RuntimeException {
    public ElementAlreadyExistException(Long id){
        super("Element with id "+id+" already exist.");
    }
}
