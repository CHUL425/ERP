package com.erp.layout.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class MainController {

    @GetMapping("/main")
    public String main() {
        log.info("메인 화면...");
        
        
        return "main";
    }
    
}