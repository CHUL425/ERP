package com.erp.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.erp.security.security.CustomAccessDeniedHandler;
import com.erp.security.security.CustomUserDetailsService;
import com.erp.security.security.LoginSuccessHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration                  // 설정 클래스
@EnableWebSecurity              // 해당 클래스를 스프링 시큐리티 설정 빈으로 등록
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//public class SecurityConfig {

    @Autowired
    private PasswordEncoder passwordEncoder;   // 비밀번호 암호화 객체

    @Autowired
    private DataSource dataSource;             // application.properites 에 정의한 데이터 소스를 가져오는 객체

    // @Autowired
    // private CustomUserDetailsService customUserDetailsService;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 스프링 시큐리티 설정
        log.info("스프링 시큐리티 설정...");

        // 인가 설정
        http.authorizeRequests((auth)->auth.antMatchers("/**").permitAll()
                                           .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                                           .antMatchers("/admin/**").hasRole("ADMIN")
                                           // anyRequest()         : 모든(이외의) 요청을 지정
                                           // authenticated()      : 인증된 사용자만 허용
                                           // .anyRequest().permitAll()
                                           .anyRequest().authenticated()
                              );

        // 로그인 설정
        http.formLogin((form)->form.defaultSuccessUrl("/")         // 로그인 성공 시, URL : "/"(기본값)
                                   .loginPage("/login")            // 커스텀 로그인 페이지 지정 (default:/login)
                                   //.loginProcessingUrl("/loginPro")// 커스텀 로그인 요청 처리 경로 지정 (default:/login)
                                   .usernameParameter("id")        // 아이디 요청 파라미터 이름 설정  (default:username)
                                   .passwordParameter("pw")        // 비밀번호 요청 파라미터 이름 설정 (default:password)
                                   .successHandler(authenticationSuccessHandler()) // 로그인 성공 처리자 빈을 지정
                                   .permitAll()
                      );

        // 로그아웃 설정
        http.logout((logout)->logout.logoutSuccessUrl("/login")
                                    .logoutUrl("/logout")
                                    .permitAll()
                   );

        // 자동로그인 설정
        http.rememberMe((remember)->remember.key("jung")
                                            .tokenRepository(tokenRepository())
                                            .tokenValiditySeconds( 60 * 60 * 24 * 7)
                       );
                                                       
        // 인증 예외 처리
        http.exceptionHandling((exception)->exception.accessDeniedHandler(accessDeniedHandler())
                                                     .accessDeniedPage("/exception")
                              );
                                                 
        // CSRF 방지 기능 비활성화 설정
        // http.csrf().disable();
    }

    // 👮‍♂️🔐사용자 인증 관리 메소드
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // ============================================================================
        // 인증 방식 : 인메모리 방식
        // auth.inMemoryAuthentication()
        //     .withUser("user").password(passwordEncoder.encode("1234")).roles("ROLE_USER")
        //     .and()
        //     .withUser("admin").password(passwordEncoder.encode("3456")).roles("ROLE_ADMIN")
        //     ;

        
        // ============================================================================
        // // 인증 방식 : JDBC 인증
        // String userSql = "SELECT USER_ID AS USERNAME, USER_PW AS PASSWORD, ENABLED"
        //                + "  FROM USER                                             "
        //                + " WHERE USER_ID = ?                                      ";

        // String authSql = "SELECT USER_ID AS USERNAME, AUTH" 
        //                + "  FROM USER_AUTH                "
        //                + " WHERE USER_ID = ?              ";        

        // auth.jdbcAuthentication().dataSource(dataSource)              // 데이터 소스 등록
        //                          .usersByUsernameQuery(userSql)       // 인증 쿼리 (아이디/비밀번호/활성여부)
        //                          .authoritiesByUsernameQuery(authSql) // 인가 쿼리 (아이디/권한)
        //                          .passwordEncoder(passwordEncoder);   // 비밀번호 암호화 방식 지정 - BCryptPasswordEncoder 또는 NoOpPasswordEncoder
        
                                 
        // ============================================================================
        // 인증 방식 : 사용자 정의 인증 (UserDetails)
        // 비밀번호 암호화 방식 지정 - BCryptPasswordEncoder 또는 NoOpPasswordEncoder
        auth.userDetailsService(customUserDetailsService()).passwordEncoder(passwordEncoder);
                    
    }

    // PersistentRepository 토큰정보 객체 - 빈 등록
    @Bean
    public PersistentTokenRepository tokenRepository() {
        // JdbcTokenRepositoryImpl : 토큰 저장 데이터 베이스를 등록하는 객체
        JdbcTokenRepositoryImpl repositoryImpl = new JdbcTokenRepositoryImpl(); 
        repositoryImpl.setDataSource(dataSource);   // 토큰 저장소를 사용하는 데이터 소스 지정
        return repositoryImpl;
    }

        
    // 인증 성공 처리 클래스 - 빈 등록
    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new LoginSuccessHandler();
    }


    // 사용자 정의 인증 구현 클래스 - 빈 등록
    @Bean
    public UserDetailsService customUserDetailsService() {
        return new CustomUserDetailsService();
    }

    // 인증 관리자 클래스 - 빈 등록
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    // 접근 거부 처리자 - 빈 등록
    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }
    
}
