package com.example.twitter.service;

import com.example.twitter.dto.RetweetRequestDto;
import com.example.twitter.dto.RetweetResponseDto;
import com.example.twitter.dto.UserRequestDto;
import com.example.twitter.entity.Comment;
import com.example.twitter.entity.Retweet;
import com.example.twitter.exception.CommentNotFoundException;
import com.example.twitter.exception.RetweetNotFoundException;
import com.example.twitter.mapper.RetweetMapper;
import com.example.twitter.repository.RetweetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RetweetServiceImpl implements RetweetService{

    @Autowired
    private final RetweetRepository retweetRepository;

    @Autowired
    private final RetweetMapper retweetMapper;
    @Override
    public List<RetweetResponseDto> getAll() {
        return retweetRepository
                .findAll()
                .stream()
                .map(retweetMapper::toResponseDto)
                .toList();
    }

    @Override
    public RetweetResponseDto get(Long id) {
        Optional<Retweet> optionalRetweet = retweetRepository.findById(id);

        if(optionalRetweet.isPresent()){
            return retweetMapper.toResponseDto(optionalRetweet.get());
        }

        throw new RetweetNotFoundException("Retweet bulunamadi, id : " + id);
    }

    @Override
    public RetweetResponseDto create(RetweetRequestDto retweetRequestDto) {
        Retweet retweet = retweetRepository.save(retweetMapper.toEntity(retweetRequestDto));
        return retweetMapper.toResponseDto(retweet);
    }

    @Override
    public void delete(Long id) {
        retweetRepository.deleteById(id);
    }
}
