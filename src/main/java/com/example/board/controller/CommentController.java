package com.example.board.controller;

import com.example.board.dto.CommentDTO;
import com.example.board.entity.BoardEntity;
import com.example.board.service.BoardService;
import com.example.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    private final BoardService boardService;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody CommentDTO commentDTO) {
        System.out.println("commentDTO = " + commentDTO);
        try {
            commentService.save(commentDTO);
            List<CommentDTO> commentDTOList = commentService.findAll(commentDTO.getBoard_id());
            return new ResponseEntity<>(commentDTOList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
