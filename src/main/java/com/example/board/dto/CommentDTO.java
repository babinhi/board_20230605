package com.example.board.dto;

import com.example.board.entity.CommentEntity;
import com.example.board.util.UtilClass;
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
    private String createdAt;
    private String updateAt;


    public static CommentDTO toDTO (CommentEntity commentEntity){
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(commentEntity.getId());
        commentDTO.setComment_writer(commentEntity.getComment_writer());
        commentDTO.setComment_contents(commentEntity.getComment_contents());
        commentDTO.setBoard_id(commentEntity.getBoardEntity().getId());
        commentDTO.setCreatedAt(UtilClass.dateFormat(commentEntity.getCreatedAt()));
        commentDTO.setUpdateAt(UtilClass.dateFormat(commentEntity.getUpdateAt()));
        return commentDTO;

    }

}
