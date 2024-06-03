package com.erp.shop.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Users {
    private String userId       ;
    private String password     ;
    private String passwordCheck;  // 비밀번호 확인
    private String name         ;
    private String email        ;
    private int    enabled      ;  // 휴면여부
    private Date   createdat    ;
    private Date   updatedat    ;
   
    List<UserAuth> authList     ;  // 권한 목록
}