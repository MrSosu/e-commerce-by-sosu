package com.sosu.ordini.exceptions;

public class PurchaseProductsFailedException extends RuntimeException {

    private String message;

    public PurchaseProductsFailedException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
