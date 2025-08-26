package com.example.twitter.mapper;

import com.example.twitter.dto.*;
import com.example.twitter.entity.Tweet;
import org.springframework.stereotype.Component;

@Component
public class TweetMapper {
    public Tweet toEntity(TweetRequestDto tweetRequestDto){
        Tweet tweet = new Tweet();
        tweet.setContent(tweetRequestDto.content());
        tweet.setCreatedAt(tweetRequestDto.createdAt());
        tweet.setUpdatedAt(tweetRequestDto.updatedAt());
        return tweet;
    }

    public TweetResponseDto toResponseDto(Tweet tweet){
        return new TweetResponseDto(tweet.getContent(),tweet.getCreatedAt(),tweet.getUpdatedAt());
    }

    public Tweet updateEntity(Tweet tweetToUpdate, TweetPatchRequestDto tweetPatchRequestDto){

        if(tweetPatchRequestDto.content() != null){
            tweetToUpdate.setContent(tweetPatchRequestDto.content());
        }

        return tweetToUpdate;
    }
}
