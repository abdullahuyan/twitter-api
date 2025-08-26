package com.example.twitter.controller;

import com.example.twitter.dto.*;
import com.example.twitter.service.CommentService;
import com.example.twitter.service.RetweetService;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class RetweetController {

    @Autowired
    private final RetweetService retweetService;

    @GetMapping
    public List<RetweetResponseDto> getAll(){
        return retweetService.getAll();
    }

    @GetMapping("/{id}")
    public RetweetResponseDto get(@Positive @PathVariable("id") Long id){
        return retweetService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RetweetResponseDto create(@Validated @RequestBody RetweetRequestDto retweetRequestDto){
        return retweetService.create(retweetRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Positive @PathVariable("id") Long id){
        retweetService.delete(id);
    }
}
