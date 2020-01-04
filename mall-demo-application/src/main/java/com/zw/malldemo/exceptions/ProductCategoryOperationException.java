package com.zw.malldemo.exceptions;

public class ProductCategoryOperationException extends RuntimeException{
    private static final long serialVersionUID = 1731072051960995926L;

    public ProductCategoryOperationException(String message) {
        super(message);
    }
}
