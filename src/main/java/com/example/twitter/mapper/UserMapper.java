package com.example.twitter.mapper;

import com.example.twitter.dto.UserPatchRequestDto;
import com.example.twitter.dto.UserRequestDto;
import com.example.twitter.dto.UserResponseDto;
import com.example.twitter.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRequestDto userRequestDto){
        User user = new User();
        user.setUsername(userRequestDto.username());
        user.setEmail(userRequestDto.email());
        return user;
    }

    public UserResponseDto toResponseDto(User user){
        return new UserResponseDto(user.getUsername(), user.getEmail());
    }

    public User updateEntity(User userToUpdate, UserPatchRequestDto userPatchRequestDto){

        if(userPatchRequestDto.username() != null){
            userToUpdate.setUsername(userPatchRequestDto.username());
        }

        if(userPatchRequestDto.email() != null){
            userToUpdate.setEmail(userPatchRequestDto.email());
        }

        return userToUpdate;
    }
}
