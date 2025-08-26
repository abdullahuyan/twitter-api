package com.example.twitter.dto;

import com.example.twitter.entity.Tweet;
import com.example.twitter.entity.User;

import java.time.LocalDateTime;

public record RetweetResponseDto(
        LocalDateTime createdAt,
        User user,
        Tweet tweet
) {
}
