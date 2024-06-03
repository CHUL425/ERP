package com.erp.bulletinboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;

import com.erp.bulletinboard.mapper.UserMapper;
import com.erp.bulletinboard.model.UserDTO;
import com.erp.bulletinboard.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    // 사용자 등록 (사용자 가입)
    @Override
    public int insert(UserDTO user) throws Exception {

        // 비밀번호 암호화
        String userPassword    = user.getPassword();
        String encodedPassword = passwordEncoder.encode(userPassword);
        user.setPassword(encodedPassword);

        // 사용자 등록
        int result = userMapper.createUser(user);

        return result;
    }

    // 사용자 조회
    @Override
    public UserDTO select(String userId) throws Exception {
        return userMapper.getUser(userId);
    }

    // 로그인 GET http://localhost:4040/login?userId=user&password=123456
    @Override
    public void login(UserDTO user, HttpServletRequest request) throws Exception {
        String username = user.getUserId()  ;
        String password = user.getPassword();
        
        // System.out.println("username : " + username);
        // System.out.println("password : " + password);

        // AuthenticationManager
        // 아이디, 패스워드 인증 토큰 생성
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        
        // 토큰에 요청정보 등록
        token.setDetails( new WebAuthenticationDetails(request) );

        // 토큰을 이용하여 인증 요청 -로그인
        Authentication authentication = authenticationManager.authenticate(token);

        // System.out.println("인증 여부 : " +  authentication.isAuthenticated() );

        User authUser = (User) authentication.getPrincipal();
        // System.out.println("인증된 사용자 아이디 : " + authUser.getUsername());

        // 시큐리티 컨텍스트에 인증된 사용자 등록
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    // 사용자정보 수정
    @Override
    public int update(UserDTO user) throws Exception {
        String userPassword    = user.getPassword();  // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(userPassword);
        user.setPassword(encodedPassword);

        int result = userMapper.updateUser(user);

        return result;
    }

    // 사용자 삭제 (사용자 탈퇴)
    @Override
    public int delete(String userId) throws Exception {
        return userMapper.removeUser(userId);
    }
}