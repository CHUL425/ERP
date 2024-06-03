package com.erp.bulletinboard.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.erp.bulletinboard.model.UserDTO;

@Mapper
public interface UserMapper {

    // 회원 등록
    public int createUser(UserDTO user) throws Exception;
    
    // 회원 조회
    public UserDTO getUser(String userId) throws Exception;

    // 회원 수정
    public int updateUser(UserDTO user) throws Exception;

    // 회원 삭제
    public int removeUser(String userId) throws Exception;
    
}