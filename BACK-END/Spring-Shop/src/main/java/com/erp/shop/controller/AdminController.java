package com.erp.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {
    
    // @PreAuthorize("hasRole('ROLE_ADMIN')")   
    @GetMapping(value={"/", ""})   // /admin/, /admin
    public String index() {
        log.info("[GET] - /admin");
        
        return "admin/index";
    }
}