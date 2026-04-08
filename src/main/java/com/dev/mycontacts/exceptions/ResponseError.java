package com.dev.mycontacts.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ResponseError {
    private HttpStatus status;
    private LocalDateTime timestamp;
    private String message;

    private List<Error> errors;

    public ResponseError() {}

    public ResponseError(HttpStatus status, LocalDateTime timestamp, String message) {
        this.status = status;
        this.timestamp = timestamp;
        this.errors = new ArrayList<>();
        this.message = message;
    }

    public Integer getStatus() {
        return status.value();
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void addError(Error error) {
        this.errors.add(error);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
