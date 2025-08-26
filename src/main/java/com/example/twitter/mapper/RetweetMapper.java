package com.example.twitter.mapper;

import com.example.twitter.dto.CommentRequestDto;
import com.example.twitter.dto.CommentResponseDto;
import com.example.twitter.dto.RetweetRequestDto;
import com.example.twitter.dto.RetweetResponseDto;
import com.example.twitter.entity.Comment;
import com.example.twitter.entity.Retweet;
import com.example.twitter.entity.Tweet;
import com.example.twitter.entity.User;

public class RetweetMapper {
    public Retweet toEntity(RetweetRequestDto retweetRequestDto){
        Retweet retweet = new Retweet();
        retweet.setUser(retweetRequestDto.user());
        retweet.setTweet(retweetRequestDto.tweet());
        return retweet;
    }

    public RetweetResponseDto toResponseDto(Retweet retweet){
        return new RetweetResponseDto(
               retweet.getCreatedAt() ,retweet.getUser(),retweet.getTweet()
        );
    }
}
