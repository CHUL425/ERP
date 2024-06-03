package com.erp.mvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.erp.mvc.dto.Board;

@Repository    // 데이터 접근 객체로 빈 등록
public class BoardDAO {
	
	public List<Board> list() {
		List<Board> boardList = new ArrayList<Board>();
		boardList.add(new Board(1, "아버지를 아버지로..", "홍길동", "게시판을 적어주세요.-내용1"));
		boardList.add(new Board(2, "왜놈을 모두 죽여라.", "이순신", "게시판을 적어주세요.-내용2"));
		boardList.add(new Board(3, "대한독립만세 !!!"   , "윤관순", "게시판을 적어주세요.-내용3"));
		return boardList;
	}
	
	public Board select(int boardNo) {
		Board board = new Board(1, "제목", "작성자", "내용");
		return board;
	}
	
	public int insert(Board board) {
		int result = 0;
		return result;
	}
	
	public int update(Board board) {
		int result = 0;
		return result;
	}
	
	public int delete(int boardNo) {
		int result = 0;
		return result;
	}

}