package com.example.twitter.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class TweetNotFoundException extends UserException{

    public TweetNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
