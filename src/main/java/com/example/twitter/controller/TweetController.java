package com.example.twitter.controller;

import com.example.twitter.dto.*;
import com.example.twitter.service.TweetService;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweets")
@RequiredArgsConstructor
public class TweetController {
    @Autowired
    private TweetService tweetService;

    @GetMapping
    public List<TweetResponseDto> getAll(){
        return tweetService.getAll();
    }

    @GetMapping("/{id}")
    public TweetResponseDto get(@Positive @PathVariable("id") Long id){
        return tweetService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TweetResponseDto create(@Validated @RequestBody TweetRequestDto tweetRequestDto){
        return tweetService.create(tweetRequestDto);
    }

    @PutMapping("/{id}")
    public TweetResponseDto replaceOrCreate(@Positive @PathVariable("id") Long id,
                                           @Validated @RequestBody TweetRequestDto tweetRequestDto){
        return tweetService.replaceOrCreate(id, tweetRequestDto);
    }

    @PatchMapping("/{id}")
    public TweetResponseDto update(@Positive @PathVariable("id") Long id,
                                  @Validated @RequestBody TweetPatchRequestDto tweetPatchRequestDto){
        return tweetService.update(id, tweetPatchRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Positive @PathVariable("id") Long id){
        tweetService.delete(id);
    }
}
