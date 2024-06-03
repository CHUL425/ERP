package com.erp.bulletinboard.security;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.erp.bulletinboard.model.CustomUserDTO;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authManager;
    private final JwtProvider           jwtProvider;

    public JwtLoginFilter(AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
        this.authManager = authenticationManager;
        this.jwtProvider = jwtProvider          ;

        // 필터 URL 경로 설정 : /login
        setFilterProcessesUrl(JwtConstants.AUTH_LOGIN_URL);
    }

     // 인증 시도 메소드 - /login 경로로 요청하면, 필터로 걸러서 인증을 시도
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        String username = request.getParameter("userId");
        String password = request.getParameter("password");

        // System.out.println("JwtLoginFilter::attemptAuthentication-request : " + request);
        // System.out.println("JwtLoginFilter::attemptAuthentication-username : " + username);
        // System.out.println("JwtLoginFilter::attemptAuthentication-password : " + password);

        // 사용자 인증정보 객체 생성
         UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        // System.out.println("JwtLoginFilter::attemptAuthentication-token : " + token);

        // 사용자 인증 (로그인)
        Authentication authentication = authManager.authenticate(token);
            
        return authentication;
    }

     // 인증 성공 메소드 - JWT을 생성, 응답 헤더에 설정
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {

        // System.out.println("인증 성공...");

        CustomUserDTO user = (CustomUserDTO) authentication.getPrincipal();
        String userId = user.getUser().getUserId();
        String role   = user.getUser().getAuth()  ;

        // 토큰 생성 요청
        String jwt = jwtProvider.generateToken(userId, role);

        // { Authorization : Bearer + {jwt} } 
        response.addHeader(JwtConstants.TOKEN_HEADER, JwtConstants.TOKEN_PREFIX + jwt);
        response.setStatus(200);
    }
    
    // 인증 실폐
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {
        // System.out.println("인증 실패... : 아이디 또는 비밀번호가 일치하지 않습니다.");

        //response.sendError(401, "인증에 실폐했습니다.");
        response.setStatus(401);   // 401 (UNAUTHORIZED)
    }
 }