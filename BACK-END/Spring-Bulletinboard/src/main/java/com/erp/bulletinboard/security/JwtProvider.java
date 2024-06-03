package com.erp.bulletinboard.security;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;
import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.erp.bulletinboard.mapper.UserMapper;
import com.erp.bulletinboard.model.CustomUserDTO;
import com.erp.bulletinboard.model.UserDTO;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtProvider {

    @Autowired
    private JwtProps jwtProps;
    
     @Autowired
    private UserMapper userMapper;
    
    // JWT 토큰 생성
    public String generateToken(String userId, String role) {
        String jwt = Jwts.builder().signWith( getShaKey(), Jwts.SIG.HS512 )                          // 서명에 사용할 키와 알고리즘 설정
                                   .header().add("typ", JwtConstants.TOKEN_TYPE)                     // 헤더 설정 (JWT)
                                   .and()
                                   .expiration(new Date(System.currentTimeMillis() + 1000*60*60*10)) // 토큰 만료 시간 설정 (10시간)
                                   .claim("uid", userId)                                             // 클레임 설정: 사용자 아이디
                                   .claim("rol", role)                                               // 클레임 설정: 권한
                                   .compact();      
        
        // System.out.println("jwt:[" + jwt + "]");

        return jwt;                
    }

    // 토큰 해석 Authorization
    public UsernamePasswordAuthenticationToken getAuthentication(String authHeader) {
        if (authHeader == null || authHeader.length() == 0 ) return null;

        try {
            Jws<Claims> parsedToken = ParserToken(authHeader);
            // System.out.println("parsedToken:" + parsedToken);
            
            String userId = parsedToken.getPayload().get("uid").toString();   // 인증된 사용자 아이디
            String role   = parsedToken.getPayload().get("rol").toString();   // 인증된 사용자 권한

            // 토큰에 userId 있는지 확인
            if( userId == null || userId.length() == 0 ) return null;         

            // userId, auth 세팅
            UserDTO user = new UserDTO();
            user.setUserId(userId);
            user.setAuth(role);
            
            // CustomeUser에 인증된 사용자 권한담기
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(role));  

            // 사용자 정보를 조회해서 name, email도 담아주기
            try {
                UserDTO userInfo = userMapper.getUser(userId);
                if( userInfo != null ) {
                    user.setName     (userInfo.getName()     );
                    user.setEmail    (userInfo.getEmail()    );
                    user.setImage    (userInfo.getImage()    );
                    user.setEnabled  (userInfo.getEnabled()  );
                    user.setCreatedAt(userInfo.getCreatedAt());
                    user.setUpdatedAt(userInfo.getUpdatedAt());
                }
            } catch (Exception e) {
                // System.out.println(e.getMessage());
                // System.out.println("토큰 유효 -> DB 추가 정보 조회시 에러 발생...");
            }

            UserDetails userDetails = new CustomUserDTO(user);

            return new UsernamePasswordAuthenticationToken(userDetails, null, authorities); // (사용자정보객체, 비밀번호, 사용자의 권한)

        } catch (ExpiredJwtException exception) {
            // System.out.println("Request to parse expired JWT:" +  exception.getMessage());

        } catch (UnsupportedJwtException exception) {
            // System.out.println("Request to parse unsupported JWT:" +  exception.getMessage());

        } catch (MalformedJwtException exception) {
            // System.out.println("Request to parse invalid JWT:" +  exception.getMessage());

        } catch (IllegalArgumentException exception) {
            // System.out.println("Request to parse empty or null JWT:" +  exception.getMessage());

        }

        return null;
    }

    // 토큰 유효성 검사
    public boolean validateToken(String authHeader) {
        // System.out.println("JwtProvider::validateToken-jwt:[" + authHeader + "]");
        try {
            Jws<Claims> parsedToken = ParserToken(authHeader);
            // System.out.println("parsedToken:" + parsedToken);

            // 만료시간과 현재시간 비교
            // 2023.12.01 vs 2023.12.14  --> 만료  : true  --->  false
            // 2023.12.30 vs 2023.12.14  --> 유효  : false --->  true
            Date exp = parsedToken.getPayload().getExpiration();

            return !exp.before(new Date());
            
        } catch (ExpiredJwtException exception) {
            // System.out.println("Token Expired");                 // 토큰 만료 

        } catch (JwtException exception) {
            // System.out.println("Token Tampered");                // 토큰 손상

        } catch (NullPointerException exception) {
            // System.out.println("Token is null");                 // 토큰 없음

        } catch (Exception e) {
	    }

        return false;
    }

    // jwt 추출, 파싱
    private Jws<Claims> ParserToken(String authHeader) {
        // System.out.println("JwtProvider::ParserToken-authHeader:[" + authHeader + "]");
        if (authHeader == null || authHeader.length() == 0 ) return null;

        String jwt = authHeader.replace(JwtConstants.TOKEN_PREFIX, "");  // jwt 추출 (Bearer + {jwt}) ➡ {jwt}
        
        Jws<Claims> parsedToken = Jwts.parser()                          // JWT 파싱
                                      .verifyWith(getShaKey())
                                      .build()
                                      .parseSignedClaims(jwt);    

        // PAYLOAD
        // {
        //     "exp": 1703140095,        ⬅ 만료기한 추출
        //     "uid": "user",
        //     "rol": [
        //         "ROLE_USER"
        //     ]   
        // }
                                      
        System.out.println("######################### 토큰 정보 #########################");
        System.out.println("parsedToken : " + parsedToken);
        System.out.println("exp:[" + parsedToken.getPayload().getExpiration()       + "]");
        System.out.println("uid:[" + parsedToken.getPayload().get("uid").toString() + "]");
        System.out.println("rol:[" + parsedToken.getPayload().get("rol").toString() + "]");
        System.out.println("############################################################");
        
        return parsedToken;
    }

    // secretKey ➡ signingKey
    private byte[] getSigningKey() {
		return jwtProps.getSecretKey().getBytes();
	}

    // secretKey ➡ (HMAC-SHA algorithms) ➡ signingKey
    private SecretKey getShaKey() {
        return Keys.hmacShaKeyFor(getSigningKey());
    }
}