package com.erp.board.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class Homecontroller {
    
    @GetMapping(value="/")
    public String home() {
        
        return "index";
    }
    
}
