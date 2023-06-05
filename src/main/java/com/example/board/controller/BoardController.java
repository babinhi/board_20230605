package com.example.board.controller;

import com.example.board.dto.BoardDTO;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/save")
    public String saveForm(){
        return "boardPages/boardSave";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO){
        boardService.save(boardDTO);
        return "redirect:/board/";
    }
    @GetMapping("/")
    public String findAll(Model model){
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "boardPages/boardList";
    }
    @GetMapping("/update")
    public String updateForm(HttpSession session, Model model) {
        Long id = (Long) session.getAttribute("board_writer");
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("boardDTO", boardDTO);
        return "boardPages/boardUpdate";
    }
    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody BoardDTO boardDTO) {
        boardService.update(boardDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model){
        boardService.updateHits(id);
        BoardDTO boardDTO = null;
        try {
            boardDTO = boardService.findById(id);
        }catch (NoSuchElementException e){
            return "boardPages/boardNotFound";
        }
        model.addAttribute("board", boardDTO);
        return "boardPages/boardDetail";
    }
}