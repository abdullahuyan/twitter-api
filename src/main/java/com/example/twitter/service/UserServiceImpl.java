package com.example.twitter.service;

import com.example.twitter.dto.UserPatchRequestDto;
import com.example.twitter.dto.UserRequestDto;
import com.example.twitter.dto.UserResponseDto;
import com.example.twitter.entity.User;
import com.example.twitter.exception.UserNotFoundException;
import com.example.twitter.mapper.UserMapper;
import com.example.twitter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final UserMapper userMapper;

    @Override
    public List<UserResponseDto> getAll() {
        return userRepository
                .findAll()
                .stream()
                .map(u -> userMapper.toResponseDto(u))
                .toList();
    }

    @Override
    public UserResponseDto get(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isPresent()){
            return userMapper.toResponseDto(optionalUser.get());
        }

        throw new UserNotFoundException("Kullanıcı bulunamadi, id : " + id);
    }

    @Override
    public UserResponseDto create(UserRequestDto userRequestDto) {
        User user = userRepository.save(userMapper.toEntity(userRequestDto));
        return userMapper.toResponseDto(user);
    }

    @Override
    public UserResponseDto replaceOrCreate(Long id, UserRequestDto userRequestDto) {
        User user = userMapper.toEntity(userRequestDto);

        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isPresent()){
            user.setId(id);
            return userMapper.toResponseDto(userRepository.save(user));
        }
        return userMapper.toResponseDto(userRepository.save(user));
    }

    @Override
    public UserResponseDto update(Long id, UserPatchRequestDto userPatchRequestDto) {
        User userToUpdate = userRepository
                .findById(id)
                .orElseThrow(()-> new UserNotFoundException("Kullanıcı bulunamadi, id : " + id));

        userToUpdate = userMapper.updateEntity(userToUpdate, userPatchRequestDto);

        return userMapper.toResponseDto(userRepository.save(userToUpdate));
    }


    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
