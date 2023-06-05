package com.example.board.entity;

import com.example.board.dto.BoardDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Setter
@Getter
@Table(name = "board_table")
@ToString

public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(length = 20, nullable = false)
    private String board_write;

    @Column(length = 50, nullable = false)
    private String board_title;

    @Column(length = 20, nullable = false)
    private String board_pass;

    @Column(length = 500)
    private String board_contents;

    @Column
    private int board_hits;

    @CreationTimestamp
    @Column(updatable = false) // updateble에 false를 줘야 insert할때만 값(시간)이 주어짐
    private LocalDateTime createdAt;


    public static BoardEntity toSaveEntity(BoardDTO boardDTO) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoard_write(boardDTO.getBoard_writer());
        boardEntity.setBoard_title(boardDTO.getBoard_title());
        boardEntity.setBoard_pass(boardDTO.getBoard_pass());
        boardEntity.setBoard_contents(boardDTO.getBoard_contents());
        boardEntity.setBoard_hits(0);
        return boardEntity;

    }

    public static BoardEntity toUpdateEntity(BoardDTO boardDTO) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setId(boardDTO.getId());
        boardEntity.setBoard_write(boardDTO.getBoard_writer());
        boardEntity.setBoard_title(boardDTO.getBoard_title());
        boardEntity.setBoard_pass(boardDTO.getBoard_pass());
        boardEntity.setBoard_contents(boardDTO.getBoard_contents());
        return boardEntity;
    }
}
