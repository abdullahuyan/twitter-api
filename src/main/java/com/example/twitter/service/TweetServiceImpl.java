package com.example.twitter.service;

import com.example.twitter.dto.TweetPatchRequestDto;
import com.example.twitter.dto.TweetRequestDto;
import com.example.twitter.dto.TweetResponseDto;
import com.example.twitter.entity.Tweet;
import com.example.twitter.exception.TweetNotFoundException;
import com.example.twitter.mapper.TweetMapper;
import com.example.twitter.repository.TweetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TweetServiceImpl implements TweetService{

    @Autowired
    private final TweetRepository tweetRepository;

    @Autowired
    private final TweetMapper tweetMapper;

    @Override
    public List<TweetResponseDto> getAll() {
        return tweetRepository
                .findAll()
                .stream()
                .map(tweetMapper::toResponseDto)
                .toList();
    }

    @Override
    public TweetResponseDto get(Long id) {
        Optional<Tweet> optionalTweet = tweetRepository.findById(id);

        if(optionalTweet.isPresent()){
            return tweetMapper.toResponseDto(optionalTweet.get());
        }

        throw new TweetNotFoundException("Tweet bulunamadi, id : " + id);
    }

    @Override
    public TweetResponseDto create(TweetRequestDto tweetRequestDto) {
        Tweet tweet = tweetRepository.save(tweetMapper.toEntity(tweetRequestDto));
        return tweetMapper.toResponseDto(tweet);
    }

    @Override
    public TweetResponseDto replaceOrCreate(Long id, TweetRequestDto tweetRequestDto) {
        Tweet tweet = tweetMapper.toEntity(tweetRequestDto);

        Optional<Tweet> optionalTweet = tweetRepository.findById(id);

        if(optionalTweet.isPresent()){
            tweet.setId(id);
            return tweetMapper.toResponseDto(tweetRepository.save(tweet));
        }
        return tweetMapper.toResponseDto(tweetRepository.save(tweet));
    }

    @Override
    public TweetResponseDto update(Long id, TweetPatchRequestDto tweetPatchRequestDto) {
        Tweet tweetToUpdate = tweetRepository
                .findById(id)
                .orElseThrow(()-> new TweetNotFoundException("Tweet bulunamadi, id : " + id));

        tweetToUpdate = tweetMapper.updateEntity(tweetToUpdate, tweetPatchRequestDto);

        return tweetMapper.toResponseDto(tweetRepository.save(tweetToUpdate));
    }

    @Override
    public void delete(Long id) {
        tweetRepository.deleteById(id);
    }
}
