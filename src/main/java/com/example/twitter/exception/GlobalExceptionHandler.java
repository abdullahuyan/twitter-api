package com.example.twitter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(UserException exception){
        UserErrorResponse response = new UserErrorResponse(
                exception.getMessage(),
                exception.getStatus().value(),
                System.currentTimeMillis(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(response, exception.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(Exception exception){
        UserErrorResponse response = new UserErrorResponse(
                exception.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                System.currentTimeMillis(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
