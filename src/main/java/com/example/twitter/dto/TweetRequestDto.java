package com.example.twitter.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record TweetRequestDto(
        @NotNull
        @NotBlank
        @NotEmpty
        @Size(max = 300)
        String content,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
