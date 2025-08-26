package com.example.twitter.service;

import com.example.twitter.dto.*;

import java.util.List;

public interface TweetService {
    List<TweetResponseDto> getAll();
    TweetResponseDto get(Long id);
    TweetResponseDto create(TweetRequestDto tweetRequestDto);
    TweetResponseDto replaceOrCreate(Long id, TweetRequestDto tweetRequestDto);
    TweetResponseDto update(Long id, TweetPatchRequestDto tweetPatchRequestDto);
    void delete(Long id);
}
