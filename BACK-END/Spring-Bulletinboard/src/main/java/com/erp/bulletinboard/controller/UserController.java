package com.erp.bulletinboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.erp.bulletinboard.model.CustomUserDTO;
import com.erp.bulletinboard.model.UserDTO;
import com.erp.bulletinboard.service.UserService;

/**
 *    사용자 정보
 *    [POST]        /signup  - 사용자가입          ALL
 *    [GET]         /user/me - 사용자정보 조회     (ROLE_USER)
 *    [PUT]         /user    - 사용자정보 수정     (ROLE_USER)
 *    [DELETE]      /user    - 사용자탈퇴          (ROLE_ADMIN)
 */
@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    // 사용자가입
    @PostMapping("/signup")
    public ResponseEntity<?> join(@RequestBody UserDTO user) throws Exception {
        System.out.println("[POST] - /signup");

        int result = userService.insert(user);
        if( result > 0 ) {
            System.out.println("사용자가입 성공! - SUCCESS");
            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        }
        else {
            System.out.println("사용자가입 실패! - FAIL");
            return new ResponseEntity<>("FAIL", HttpStatus.BAD_REQUEST);
        } 
    }

    // 사용자 정보 조회
    @GetMapping("/user/me")
    //@Secured("ROLE_USER")           // USER 권한 설정
    public ResponseEntity<?> me(@AuthenticationPrincipal CustomUserDTO customUser) throws Exception {
        System.out.println("[GET] - /user/me");
        
        System.out.println("::::: customUser :::::");
        System.out.println("customUser : "+ customUser);

        String userId = customUser.getUsername();

        UserDTO user = userService.select(userId);
        System.out.println("user : " + user);

        // 인증된 사용자 정보 
        if( user != null ) {
            System.out.println("사용자 인증 성공! - SUCCESS");
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

        // 인증 되지 않음
        System.out.println("사용자 인증 실패! - UNAUTHORIZED");
        return new ResponseEntity<>("UNAUTHORIZED", HttpStatus.UNAUTHORIZED);
    }

    // 사용자 정보 수정
    @PutMapping("/user")
    //@Secured("ROLE_USER")           // USER 권한 설정
    public ResponseEntity<?> update(@RequestBody UserDTO user) throws Exception {
        System.out.println("[PUT] - /user");
        System.out.println("user : " + user);
               
        int result = userService.update(user);
        System.out.println("result : " + result);
        
        if( result > 0 ) {
            System.out.println("사용자수정 성공! - SUCCESS");
            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        }
        else {
            System.out.println("사용자수정 실패! - FAIL");
            return new ResponseEntity<>("FAIL", HttpStatus.BAD_REQUEST);
        } 
    }

    // 사용자 탈퇴
    @DeleteMapping("/user/{userId}")
    //@Secured("ROLE_USER")          //  USER 권한 설정
    public ResponseEntity<?> destroy(@PathVariable("userId") String userId) throws Exception {
        System.out.println("[DELETE] - /user/{userId}");

        int result = userService.delete(userId);

        if( result > 0 ) {
            System.out.println("사용자삭제 성공! - SUCCESS");
            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        }
        else {
            System.out.println("사용자삭제 실패! - FAIL");
            return new ResponseEntity<>("FAIL", HttpStatus.BAD_REQUEST);
        }
    }
}