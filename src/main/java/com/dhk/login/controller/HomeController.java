package com.dhk.login.controller;

import com.dhk.login.domain.Role;
import com.dhk.login.security.SecurityUser;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HomeController {

    @GetMapping
    public String home(Authentication authentication, Model model) {
        if (authentication != null) {
            SecurityUser principal = (SecurityUser) authentication.getPrincipal();
            model.addAttribute("principal", principal.getMember());
            model.addAttribute("role", principal.getMember().getRole().getDescription());
        }
        return "home";
    }
}
