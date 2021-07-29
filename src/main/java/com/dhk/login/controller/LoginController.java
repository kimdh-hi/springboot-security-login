package com.dhk.login.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping
public class LoginController {

    @GetMapping("/registry")
    public String registryForm() {
        return "registration";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }
}
