package com.example.twitter.service;

import com.example.twitter.dto.UserPatchRequestDto;
import com.example.twitter.dto.UserRequestDto;
import com.example.twitter.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAll();
    UserResponseDto get(Long id);
    UserResponseDto create(UserRequestDto userRequestDto);
    UserResponseDto replaceOrCreate(Long id, UserRequestDto userRequestDto);
    UserResponseDto update(Long id, UserPatchRequestDto userPatchRequestDto);
    void delete(Long id);

}
