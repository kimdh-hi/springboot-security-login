package com.dhk.login.controller;

import com.dhk.login.security.UserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
public class HomeController {

    @GetMapping
    public String home(@AuthenticationPrincipal UserDetails principal, Model model,
                       HttpServletResponse response, HttpServletRequest request) {
        if (principal != null) {
            model.addAttribute("principal", principal.getMember());
            model.addAttribute("role", principal.getMember().getRole().getDescription());
        }

        if(response.getHeader("Authorization") != null) {
            log.info(response.getHeader("Authorization"));
        }
        if(request.getHeader("Authorization") != null) {
            log.info(request.getHeader("Authorization"));
        }
        return "home";
    }
}
