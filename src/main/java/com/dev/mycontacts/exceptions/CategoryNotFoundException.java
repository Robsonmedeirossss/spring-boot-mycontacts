package com.dev.mycontacts.exceptions;

public class CategoryNotFoundException extends RuntimeException{
    private String message;

    public CategoryNotFoundException(String message) {
        super(message);
    }
}
