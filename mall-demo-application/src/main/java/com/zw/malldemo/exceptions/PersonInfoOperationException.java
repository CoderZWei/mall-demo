package com.zw.malldemo.exceptions;

public class PersonInfoOperationException extends RuntimeException{
    private static final long serialVersionUID = 1731072051960995926L;

    public PersonInfoOperationException(String message) {
        super(message);
    }
}
