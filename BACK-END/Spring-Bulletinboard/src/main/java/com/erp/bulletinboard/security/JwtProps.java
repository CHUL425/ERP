package com.erp.bulletinboard.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties("spring.jwt") // application.properties 속성(JWT 암호화 키) 경로 지정
public class JwtProps {
    private String secretKey;    
}