package com.dev.mycontacts.exceptions;

public class ContactNotFoundException extends RuntimeException{
    private String message;

    public ContactNotFoundException(String message) {
        super(message);
    }
}
