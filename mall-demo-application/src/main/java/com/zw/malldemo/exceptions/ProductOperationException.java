package com.zw.malldemo.exceptions;

public class ProductOperationException extends RuntimeException{
    private static final long serialVersionUID = 5076172298827469013L;

    public ProductOperationException(String message) {
        super(message);
    }
}
