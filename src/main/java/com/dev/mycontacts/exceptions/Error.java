package com.dev.mycontacts.exceptions;

public class Error {
    private String property;
    private String error;

    public Error(){}

    public Error(String field, String error) {
        this.property = field;
        this.error = error;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getMessage() {
        return error;
    }

    public void setMessage(String error) {
        this.error = error;
    }
}
