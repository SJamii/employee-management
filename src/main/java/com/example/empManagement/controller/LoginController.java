package com.example.empManagement.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping
    public String loginGetController() {
        log.info(" -------- Login Get Controller ---------");
        return "login";
    }
}
