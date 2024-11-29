package com.fl.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message +" NOT FOUND");
    }
}
