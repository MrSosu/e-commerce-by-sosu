package com.sosu.ordini.exceptions;

public class OrdineNotFoundException extends RuntimeException {

    private String message;

    public OrdineNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
