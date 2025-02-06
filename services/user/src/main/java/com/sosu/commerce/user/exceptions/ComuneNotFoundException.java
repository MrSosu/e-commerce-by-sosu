package com.sosu.commerce.user.exceptions;

public class ComuneNotFoundException extends RuntimeException {

    private String message;

    public ComuneNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
