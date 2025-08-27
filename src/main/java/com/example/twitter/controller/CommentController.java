package com.example.twitter.controller;

import com.example.twitter.dto.*;
import com.example.twitter.service.CommentService;
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
public class CommentController {
    @Autowired
    private final CommentService commentService;

    @GetMapping
    public List<CommentResponseDto> getAll(){
        return commentService.getAll();
    }

    @GetMapping("/{id}")
    public CommentResponseDto get(@Positive @PathVariable("id") Long id){
        return commentService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentResponseDto create(@Validated @RequestBody CommentRequestDto commentRequestDto){
        return commentService.create(commentRequestDto);
    }

    @PutMapping("/{id}")
    public CommentResponseDto replaceOrCreate(@Positive @PathVariable("id") Long id,
                                            @Validated @RequestBody CommentRequestDto commentRequestDto){
        return commentService.replaceOrCreate(id, commentRequestDto);
    }

    @PatchMapping("/{id}")
    public CommentResponseDto update(@Positive @PathVariable("id") Long id,
                                   @Validated @RequestBody CommentPatchRequestDto commentPatchRequestDto){
        return commentService.update(id, commentPatchRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Positive @PathVariable("id") Long id){
        commentService.delete(id);
    }
}
