package com.erp.bulletinboard.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class JwtFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    public JwtFilter(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }
    
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 헤더에서 jwt 토큰을 가져옴
        String jwtHeader = request.getHeader(JwtConstants.TOKEN_HEADER);

        // jwt 토큰이 없으면 다음 필터로 이동
        // Bearer + {jwt} 체크
        if( jwtHeader == null || jwtHeader.length() == 0 || !jwtHeader.startsWith(JwtConstants.TOKEN_PREFIX) ) {
            filterChain.doFilter(request, response);
            //// System.out.println("JwtFilter::doFilterInternal...return");

            return;
        }

        // 토큰 해석
        Authentication authenticaion = jwtProvider.getAuthentication(jwtHeader);
        
        // 토큰 유효성 검사
        // System.out.println("JwtFilter::doFilterInternal-authorization : " + jwtHeader  );
        if (jwtProvider.validateToken(jwtHeader)) {
            // System.out.println("유효한 JWT 토큰입니다.");

            // 로그인
            SecurityContextHolder.getContext().setAuthentication(authenticaion);
        }

        // 다음 필터
        filterChain.doFilter(request, response);

        // System.out.println("JwtFilter::doFilterInternal...End");
    }
}

