package com.example.twitter.service;

import com.example.twitter.dto.*;

import java.util.List;

public interface RetweetService {
    List<RetweetResponseDto> getAll();
    RetweetResponseDto get(Long id);
    RetweetResponseDto create(RetweetRequestDto retweetRequestDto);
    void delete(Long id);
}
