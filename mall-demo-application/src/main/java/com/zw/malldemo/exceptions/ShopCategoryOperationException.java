package com.zw.malldemo.exceptions;

public class ShopCategoryOperationException extends RuntimeException{
    private static final long serialVersionUID = 5423986306645291467L;

    public ShopCategoryOperationException(String message) {
        super(message);
    }
}
