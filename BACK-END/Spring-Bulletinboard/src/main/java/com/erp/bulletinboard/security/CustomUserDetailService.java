package com.erp.bulletinboard.security;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

import com.erp.bulletinboard.mapper.UserMapper;
import com.erp.bulletinboard.model.CustomUserDTO;
import com.erp.bulletinboard.model.UserDTO;


@Service
public class CustomUserDetailService implements UserDetailsService {
    
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) {
        // System.out.println("CustomUserDetailService::loadUserByUsername-username:[" + username + "]");

        UserDTO user = new UserDTO();
        try {
            user = userMapper.getUser(username);
            // System.out.println("user : " + user.toString());
        } catch (PersistenceException e) {
            Throwable cause = e.getCause();
            if (cause instanceof java.sql.SQLException) {
                SQLException sqlEx = (SQLException) cause;
                if (sqlEx.getSQLState() == "02000") {
                    throw new UsernameNotFoundException("사용자를 찾을 수 없습니다 : [" + username + "]");
                }
            }
            // System.out.println("userMapper.getUser-error : " + e.getMessage());
            throw new PersistenceException("데이터베이스 처리 중 예외 발생", e);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("데이터베이스 처리 중 예외 발생", e);
        }

        CustomUserDTO customUser = new CustomUserDTO(user);
        // System.out.println("CustomUserDetailService::loadUserByUsername-customUser : " + customUser.toString());

        return customUser;
    }
}