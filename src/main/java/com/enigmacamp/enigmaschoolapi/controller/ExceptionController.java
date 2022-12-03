package com.enigmacamp.enigmaschoolapi.controller;

import com.enigmacamp.enigmaschoolapi.exception.InvalidInputException;
import com.enigmacamp.enigmaschoolapi.exception.NotFoundException;
import com.enigmacamp.enigmaschoolapi.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(Integer.toString(HttpStatus.NOT_FOUND.value()), e.getMessage()));
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ErrorResponse> handleInvalidInputException(InvalidInputException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(Integer.toString(HttpStatus.BAD_REQUEST.value()), e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(Integer.toString(HttpStatus.INTERNAL_SERVER_ERROR.value()), e.getMessage()));
    }
}
