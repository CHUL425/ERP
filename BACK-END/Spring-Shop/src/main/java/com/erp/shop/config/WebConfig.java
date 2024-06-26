package com.erp.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration          // 빈 등록 설정 클래스 지정
public class WebConfig {

    @Bean                   // 빈 등록- BCrypt 해시 알고리즘을 사용하여 비밀번호 암호화 
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
}