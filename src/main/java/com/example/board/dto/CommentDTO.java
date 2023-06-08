package com.example.board.dto;

import com.example.board.entity.CommentEntity;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class CommentDTO {
    private Long id;
    private Long board_id;
    private String comment_writer;
    private String comment_contents;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;


    public static CommentDTO toDTO (CommentEntity commentEntity){
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(commentEntity.getId());
        commentDTO.setComment_writer(commentEntity.getComment_writer());
        commentDTO.setComment_contents(commentEntity.getComment_contents());
        commentDTO.setBoard_id(commentEntity.getBoardEntity().getId());
        commentDTO.setCreatedAt(commentEntity.getCreatedAt());
        commentDTO.setUpdateAt(commentEntity.getUpdateAt());
        return commentDTO;

    }

}
