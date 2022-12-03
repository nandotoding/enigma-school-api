package com.enigmacamp.enigmaschoolapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidInputException extends RuntimeException {
    public InvalidInputException() {
        super("Invalid Input");
    }

    public InvalidInputException(String message) {
        super(message);
    }
}
