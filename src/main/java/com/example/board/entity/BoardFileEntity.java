package com.example.board.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name="board_file_table")
public class BoardFileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String originalFileName;

    @Column
    private String storedFileName;

//    @Column
//    private Long boardId; 이렇게 하면 참조관계 X

    @ManyToOne(fetch = FetchType.LAZY) // 필요한 자식데이터만 호출해서 가져올것이다
//    @ManyToOne(fetch = FetchType.EAGER) // 쓰든 안쓰든 자식데이터를 가져올것이다
    @JoinColumn(name = "board_id") // 실제 DB에 생성되는 참조이름
    private BoardEntity boardEntity; // 부모 엔티티 타입으로 정의

    public static BoardFileEntity toSaveBoardFileEntity(BoardEntity savedEntity, String originalFileName, String storedFileName) {
        BoardFileEntity boardFileEntity = new BoardFileEntity();
        boardFileEntity.setBoardEntity(savedEntity);
        boardFileEntity.setOriginalFileName(originalFileName);
        boardFileEntity.setStoredFileName(storedFileName);
        return boardFileEntity;
    }
}
