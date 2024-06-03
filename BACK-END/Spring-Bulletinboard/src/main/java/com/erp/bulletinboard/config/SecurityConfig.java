package com.erp.bulletinboard.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsConfiguration;

import com.erp.bulletinboard.security.CustomUserDetailService;
import com.erp.bulletinboard.security.JwtLoginFilter;
import com.erp.bulletinboard.security.JwtFilter;
import com.erp.bulletinboard.security.JwtProvider;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Collections;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true) // // @preAuthorize, @postAuthorize, @Secured 활성화
public class SecurityConfig {

    @Autowired
    private CustomUserDetailService customUserDetailService;
    
	@Autowired
	private JwtProvider jwtProvider;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
        // System.out.println("SecurityConfig::securityFilterChain-시큐리티 설정...Begin");

        http.formLogin(login -> login.disable());  // 폼 기반 로그인 비활성화
		http.httpBasic(basic -> basic.disable());  // HTTP 기본 인증 비활성화
		http.csrf(csrf ->csrf.disable());         // CSRF(Cross-Site Request Forgery) 공격 방어 기능 비활성화
		//http.sessionManagement(mgr -> mgr.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // 세션 관리 정책 설정: STATELESS로 설정하면 서버는 세션을 생성하지 않음

        // 필터 - addFilterAt 설정 
        http.addFilterAt(new JwtLoginFilter(authManager, jwtProvider), UsernamePasswordAuthenticationFilter.class);

        // 필터 설정 
		http.addFilterBefore(new JwtFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class); // JwtTokenFilter 위치 수정 및 등록

        // 인가 설정 
        http.authorizeHttpRequests(req -> req.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                                             .requestMatchers("/" ).permitAll()
                                             .requestMatchers("/login").permitAll()
                                             .requestMatchers("/signup").permitAll()
                                             .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                                             .requestMatchers("/admin/**").hasRole("ADMIN")
                                             .anyRequest().authenticated()
                                  );

        // 인증 방식 설정 
        http.userDetailsService(customUserDetailService);

        // CORS 설정
        http.cors((corsCustomizer -> corsCustomizer.configurationSource(new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                // System.out.println("SecurityConfig::http.cors::getCorsConfiguration...");

                CorsConfiguration configuration = new CorsConfiguration();
                configuration.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
                configuration.setAllowedMethods(Collections.singletonList("*"));
                configuration.setAllowCredentials(true);
                configuration.setAllowedHeaders(Collections.singletonList("*"));
                configuration.setMaxAge(3600L);
                configuration.setExposedHeaders(Collections.singletonList("Authorization"));
                
                return configuration;
            }
        })));
        
        // System.out.println("SecurityConfig::securityFilterChain-시큐리티 설정...End");
		
		return http.build();
	}
    
    @Bean   // 암호화 알고리즘 방식: Bcrypt
    public PasswordEncoder passwordEncoder() {  
        // System.out.println("SecurityConfig::passwordEncoder");

        return new BCryptPasswordEncoder();    
    }
    
    // AuthenticationManager 빈 등록
    private AuthenticationManager authManager;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfiguration) throws Exception {
        this.authManager = authConfiguration.getAuthenticationManager();
        return authManager;
    }
    
}