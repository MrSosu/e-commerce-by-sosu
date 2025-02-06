package com.sosu.commerce.user.exceptions;

public class IndirizzoNotFoundException extends RuntimeException {

    private String message;

    public IndirizzoNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
