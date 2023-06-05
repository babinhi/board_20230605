package com.example.board.dto;

import com.example.board.entity.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@Builder //
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private Long id;
    private String board_writer;
    private String board_title;
    private String board_pass;
    private String board_contents;
    private LocalDateTime createdAt;
    private int board_hits;

    public static BoardDTO toDTO(BoardEntity boardEntity) {
//        BoardDTO boardDTO = new BoardDTO();
//        boardDTO.setId(boardEntity.getId());
//        boardDTO.setBoard_writer(boardEntity.getBoard_write());
//        boardDTO.setBoard_title(boardEntity.getBoard_title());
//        boardDTO.setBoard_contents(boardEntity.getBoard_contents());
//        boardDTO.setBoard_hits(boardEntity.getBoard_hits());
//        return boardDTO;
        return BoardDTO.builder()
                .id(boardEntity.getId())
                .board_writer(boardEntity.getBoard_write())
                .board_pass(boardEntity.getBoard_pass())
                .board_title(boardEntity.getBoard_title())
                .board_contents(boardEntity.getBoard_contents())
                .board_hits(boardEntity.getBoard_hits())
                .createdAt(boardEntity.getCreatedAt())
                .build();

    }
}
