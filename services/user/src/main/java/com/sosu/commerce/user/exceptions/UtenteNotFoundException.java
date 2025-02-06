package com.sosu.commerce.user.exceptions;

public class UtenteNotFoundException extends RuntimeException {

    private String message;

    public UtenteNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
