package com.example.board.service;

import com.example.board.dto.CommentDTO;
import com.example.board.entity.BoardEntity;
import com.example.board.entity.CommentEntity;
import com.example.board.repository.BoardFileRepository;
import com.example.board.repository.BoardRepository;
import com.example.board.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor

public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    public Long save(CommentDTO commentDTO) {
        BoardEntity boardEntity =
                boardRepository.findById(commentDTO.getBoard_id()).orElseThrow(() -> new NoSuchElementException());
        CommentEntity commentEntity = CommentEntity.toSaveEntity(boardEntity, commentDTO);
        return commentRepository.save(commentEntity).getId();
    }

    public List<CommentDTO> findAll(Long boardId) {
//        //1. BoardEntity에서 댓글목록 가져오기
        BoardEntity boardEntity = boardRepository.findById(boardId).orElseThrow(()-> new NoSuchElementException());
//        List<CommentEntity> commentEntityList = boardEntity.getCommentEntityList();
        // 2. select * from comment_table where board_id=?
        List<CommentEntity> commentEntityList = commentRepository.findByBoardEntity(boardEntity);
        List<CommentDTO> commentDTOList = new ArrayList<>();
        commentEntityList.forEach(comment ->{
            commentDTOList.add(CommentDTO.toDTO(comment));
        });
        return commentDTOList;
    }



}