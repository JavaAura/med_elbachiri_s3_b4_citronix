package com.citronix.api.exception;

public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException(Class<?> entity, Long id){
        super(entity.getSimpleName() + " with id "+id+" not found.");
    }
}
