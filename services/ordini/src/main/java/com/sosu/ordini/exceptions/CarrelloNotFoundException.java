package com.sosu.ordini.exceptions;

public class CarrelloNotFoundException extends RuntimeException {

    private String message;

    public CarrelloNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
