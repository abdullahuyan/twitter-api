package com.example.twitter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record UserRequestDto(

        @NotNull
        @NotBlank
        @NotEmpty
        @Size(max=100)
        @JsonProperty("username")
        String username,
        @JsonProperty("email")
        @NotNull
        @NotBlank
        @NotEmpty
        @Email
        @Size(max=100)
        String email,

        LocalDateTime createdAt
) {
}
