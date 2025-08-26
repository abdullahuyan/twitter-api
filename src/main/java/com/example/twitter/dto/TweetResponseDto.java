package com.example.twitter.dto;

import java.time.LocalDateTime;

public record TweetResponseDto(
        String content,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
