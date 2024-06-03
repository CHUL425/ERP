package com.erp.bulletinboard.service;

import com.erp.bulletinboard.model.UserDTO;

import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
    // 회원 등록
    public int insert(UserDTO user) throws Exception;

    // 회원 조회
    public UserDTO select(String userId) throws Exception;

    // 로그인
    public void login(UserDTO user, HttpServletRequest requset) throws Exception;

    // 회원 수정
    public int update(UserDTO user) throws Exception;

    // 회원 삭제
    public int delete(String userId) throws Exception;
}