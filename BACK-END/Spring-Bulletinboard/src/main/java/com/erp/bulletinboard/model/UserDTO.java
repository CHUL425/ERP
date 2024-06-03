package com.erp.bulletinboard.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
    private String userId       ;   // 사용자 ID
    private String password     ;   // 비밀번호
    private String passwordCheck;   // 비밀번호
    private String name         ;   // 이름
    private String email        ;   // 이메일주소
    private String image        ;   // Avatar 이미지
    private int    enabled      ;   // 가입상태
    private String auth         ;   // 사용자권한
    private Date   createdAt    ;   // 등록일자
    private Date   updatedAt    ;   // 수정일자

    public UserDTO() {}

    public UserDTO(UserDTO user) {
        this.userId        = user.getUserId()       ;
        this.name          = user.getName()         ;
        this.password      = user.getPassword()     ;
        this.passwordCheck = user.getPasswordCheck();
        this.email         = user.getEmail()        ;
        this.image         = user.getImage()        ;
        this.enabled       = user.getEnabled()      ;
        this.auth          = user.getAuth()         ;
        this.createdAt     = user.getCreatedAt()    ;
        this.updatedAt     = user.getUpdatedAt()    ;    
    }
}
