package com.zw.malldemo.exceptions;

public class AreaOperationException extends RuntimeException{
    private static final long serialVersionUID = -1512771573934050550L;

    public AreaOperationException(String message) {
        super(message);
    }
}
