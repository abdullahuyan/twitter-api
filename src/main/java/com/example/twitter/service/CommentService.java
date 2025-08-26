package com.example.twitter.service;

import com.example.twitter.dto.*;

import java.util.List;

public interface CommentService {
    List<CommentResponseDto> getAll();
    CommentResponseDto get(Long id);
    CommentResponseDto create(CommentRequestDto commentRequestDto);
    CommentResponseDto replaceOrCreate(Long id, CommentRequestDto commentRequestDto);
    CommentResponseDto update(Long id, CommentPatchRequestDto commentPatchRequestDto);
    void delete(Long id);
}
