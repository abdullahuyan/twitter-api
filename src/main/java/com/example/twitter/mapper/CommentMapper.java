package com.example.twitter.mapper;

import com.example.twitter.dto.CommentPatchRequestDto;
import com.example.twitter.dto.CommentRequestDto;
import com.example.twitter.dto.CommentResponseDto;
import com.example.twitter.entity.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {
    public Comment toEntity(CommentRequestDto commentRequestDto){
        Comment comment = new Comment();
        comment.setContent(commentRequestDto.content());
        return comment;
    }

    public CommentResponseDto toResponseDto(Comment comment){
        return new CommentResponseDto(
                comment.getContent()
        );
    }

    public Comment updateEntity(Comment commentToUpdate, CommentPatchRequestDto commentPatchRequestDto){
        if(commentPatchRequestDto.content() != null){
            commentToUpdate.setContent(commentPatchRequestDto.content());
        }
        return commentToUpdate;
    }
}
