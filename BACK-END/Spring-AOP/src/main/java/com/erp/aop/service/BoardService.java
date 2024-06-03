package com.erp.aop.service;

import com.erp.aop.dto.Board;

import java.util.List;

public interface BoardService {
    // 게시글 목록
    public List<Board> list() throws Exception;

    // 게시글 조회
    public Board select(int boardNo) throws Exception;

    // 게시글 등록
    public Integer insert(Board board) throws Exception;

    // 게시글 수정
    public Integer update(Board board) throws Exception;

    // 게시글 삭제
    public Integer delete(int boardNo) throws Exception;
}
