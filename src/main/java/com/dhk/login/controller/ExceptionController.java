package com.dhk.login.controller;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class ExceptionController {

    @GetMapping("/forbidden")
    public String exceptionHandling() {
        return "forbidden";
    }
}
