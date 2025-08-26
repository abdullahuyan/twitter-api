package com.example.twitter.dto;

import com.example.twitter.entity.Tweet;
import com.example.twitter.entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public record RetweetRequestDto(
        LocalDateTime createdAt,
        User user,
        Tweet tweet
) {
}
