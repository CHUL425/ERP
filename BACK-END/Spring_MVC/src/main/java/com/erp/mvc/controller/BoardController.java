package com.erp.mvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.erp.mvc.dto.Board;
import com.erp.mvc.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
    
    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
    

    @Autowired  // 의존성 자동주입
    private BoardService boardService;
    
    // // 게시물 목록
    // @GetMapping("/list")
    // public String list(Model model) throws Exception {   // Model  데이터 전달자
    //     logger.info("value = [/list], method = RequestMethod.GET");
        
    //     List<Board> boardList= boardService.list();  // 데이터 요청
    //     model.addAttribute("boardList", boardList);  // 모델 등록
        
    //     return "board/list";   // 뷰 페이지 지정
    // }

    // 게시물 목록-Accept:application/json
    @RequestMapping(value = "/list", produces="application/json")
    public ResponseEntity<List<Board>> listJSON() throws Exception {
        logger.info("value = [/list], produces=application/json");

        List<Board> boardList = boardService.list();

        return new ResponseEntity<List<Board>>(boardList, HttpStatus.OK);
    }
    
    // // 게시물 목록-Accept:application/xml
    // @RequestMapping(value = "/list", produces="application/xml")
    // public ResponseEntity<List<Board>> listXML() throws Exception {
    //     logger.info("value = [/list], produces=application/xml");

    //     List<Board> boardList = boardService.list();

    //     return new ResponseEntity<List<Board>>(boardList, HttpStatus.OK);
    // }    
        
    
    // 게시물 조회
    @RequestMapping(value = "/read", method = RequestMethod.GET, params = "boardNo")
    public String read(Model model, @RequestParam("boardNo") int boardNo) {
        logger.info("value = [/read], method = RequestMethod.GET boardNo:" + boardNo);

        Board board = boardService.select(boardNo);
        model.addAttribute("board", board);
        return "board/read";
    }

    // 게시물 등록
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert() {
        logger.info("value = [/insert], method = RequestMethod.GET");

        return "board/insert";
    }

    // 게시물 등록 처리
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertPro() {
        logger.info("value = [/insert], method = RequestMethod.POST");

        return "redirect:/board/list";
    }

    // 게시물 등록 처리
    @RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> insertProJSON() {
        logger.info("value = [/insert], method = RequestMethod.POST[💥JSON]");

        return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);   // 200 OK
    }    
    
    // 게시물 수정
    @RequestMapping(value = "/update", method = RequestMethod.GET, params = "boardNo")
    public String update(Model model, @RequestParam("boardNo") int boardNo) {
        logger.info("value = [/update], method = RequestMethod.GET boardNo:" + boardNo);

        Board board = boardService.select(boardNo);
        model.addAttribute("board", board);

        return "board/update";
    }

    // 게시물 수정 처리
    @RequestMapping(value = "/update", method = RequestMethod.POST, params = "boardNo")
    public String updatePro(Model model, @RequestParam("boardNo") int boardNo) {
        logger.info("value = [/update], method = RequestMethod.POST boardNo:" + boardNo);

        return "redirect:/board/list";
    }

    // 게시물 수정 처리
    @RequestMapping(value = "/update", method = RequestMethod.PUT, params = "boardNo")
    public String updateProPut(Model model, @RequestParam("boardNo") int boardNo) {
        logger.info("value = [/update], method = RequestMethod.PUT boardNo:" + boardNo);

        return "redirect:/board/list";
    }
    
    // 게시물 삭제 처리
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deletePro() {
        logger.info("value = [/delete], method = RequestMethod.POST");

        return "redirect:/board/list";
    }
}