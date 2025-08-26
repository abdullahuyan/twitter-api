package com.example.twitter.service;

import com.example.twitter.dto.CommentPatchRequestDto;
import com.example.twitter.dto.CommentRequestDto;
import com.example.twitter.dto.CommentResponseDto;
import com.example.twitter.entity.Comment;
import com.example.twitter.exception.CommentNotFoundException;
import com.example.twitter.mapper.CommentMapper;
import com.example.twitter.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    @Autowired
    private final CommentRepository commentRepository;

    @Autowired
    private final CommentMapper commentMapper;

    @Override
    public List<CommentResponseDto> getAll() {
        return commentRepository
                .findAll()
                .stream()
                .map(commentMapper::toResponseDto)
                .toList();
    }

    @Override
    public CommentResponseDto get(Long id) {
        Optional<Comment> optionalComment = commentRepository.findById(id);

        if(optionalComment.isPresent()){
            return commentMapper.toResponseDto(optionalComment.get());
        }

        throw new CommentNotFoundException("Yorum bulunamadi, id : " + id);
    }

    @Override
    public CommentResponseDto create(CommentRequestDto commentRequestDto) {
        Comment comment = commentRepository.save(commentMapper.toEntity(commentRequestDto));
        return commentMapper.toResponseDto(comment);
    }

    @Override
    public CommentResponseDto replaceOrCreate(Long id, CommentRequestDto commentRequestDto) {
        Comment comment = commentMapper.toEntity(commentRequestDto);

        Optional<Comment> optionalComment = commentRepository.findById(id);

        if(optionalComment.isPresent()){
            comment.setId(id);
            return commentMapper.toResponseDto(commentRepository.save(comment));
        }
        return commentMapper.toResponseDto(commentRepository.save(comment));
    }

    @Override
    public CommentResponseDto update(Long id, CommentPatchRequestDto commentPatchRequestDto) {
        Comment commentToUpdate = commentRepository
                .findById(id)
                .orElseThrow(()-> new CommentNotFoundException("Yorum bulunamadi, id : " + id));

        commentToUpdate = commentMapper.updateEntity(commentToUpdate, commentPatchRequestDto);

        return commentMapper.toResponseDto(commentRepository.save(commentToUpdate));
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }
}
