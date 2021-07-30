package com.dhk.login.controller;

import com.dhk.login.controller.request.RegistryRequest;
import com.dhk.login.domain.Member;
import com.dhk.login.domain.Role;
import com.dhk.login.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Controller
public class RegistryController {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/registry")
    public String registryForm(Model model) {
        model.addAttribute("member", new RegistryRequest());
        return "registration";
    }

    @PostMapping("/registry")
    public String registry(@ModelAttribute RegistryRequest registryRequest) {
        Member member = Member.builder()
                .username(registryRequest.getUsername())
                .password(passwordEncoder.encode(registryRequest.getPassword()))
                .role(registryRequest.getRole())
                .build();
        memberRepository.save(member);

        return "redirect:/login";
    }

    @ModelAttribute("roles")
    public Map<String, Role> roles() {
        Map<String, Role> map = new LinkedHashMap<>();
        map.put("관리자", Role.ROLE_ADMIN);
        map.put("매니저", Role.ROLE_MANAGER);
        map.put("일반 사용자", Role.ROLE_MEMBER);
        return map;
    }
}