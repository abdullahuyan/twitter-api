package com.example.twitter.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class RetweetNotFoundException extends UserException{

    public RetweetNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
