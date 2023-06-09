package com.example.board.repository;

import com.example.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<BoardEntity,Long> {
    // update board_table set board_hits = board_hits+1 where id = ?
    // 라는 형식 필요
    // jpql(java persistence query language): 필요한 쿼리문을 직접 적용하고자 할 때 사용
    @Modifying
//    @Query(value = "update board_table b set b.board_hits= board_hits+1 where b.id=:id", nativeQuery = true)
    // 네이티브 쿼리방식을 사용하고 싶을때(실제쿼리문을 네이티브쿼리라고함)
    @Query(value = "update BoardEntity b set b.boardHits=b.boardHits+1 where b.id=:id")
    // 테이블이름X Entity이름을 적어야함 /반드시 약칭을 사용해야함 (b) 그 이후에 약칭을 넣어서 적어야한다
    void updateHits(@Param("id") Long id);


}
