package com.dev.mycontacts.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ContactNotFoundException.class)
    public ResponseEntity<ResponseError> contactNotFoundException(ContactNotFoundException exception) {
        ResponseError responseError = new ResponseError(
                HttpStatus.NOT_FOUND,
                LocalDateTime.now(),
                exception.getMessage());

        return ResponseEntity.status(404).body(responseError);
    }

    @ExceptionHandler(CategoryNotFoundException.class)

    public ResponseEntity<ResponseError> categoryNotFoundException(CategoryNotFoundException exception) {

        ResponseError responseError = new ResponseError(
                HttpStatus.NOT_FOUND,
                LocalDateTime.now(),
                exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseError> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        ResponseError responseError = new ResponseError(HttpStatus.BAD_REQUEST, LocalDateTime.now(), "Dados inválidos");

        exception.getAllErrors().forEach(error -> {
            String field = ((FieldError) error).getField();
            String message = error.getDefaultMessage();

            responseError.addError(new Error(field, message));
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> exception(Exception exception) {
        ResponseError responseError = new ResponseError(
                HttpStatus.INTERNAL_SERVER_ERROR,
                LocalDateTime.now(),
                exception.getMessage());

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(responseError);
    }
}
