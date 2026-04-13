package com.dev.mycontacts.exceptions;

public class ContactNotFoundException extends RuntimeException {
    public ContactNotFoundException(String message) {
        super(message);
    }
}
