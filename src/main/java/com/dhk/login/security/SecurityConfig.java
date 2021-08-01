package com.dhk.login.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final KakaoOauth2UserService kakaoOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.oauth2Login().userInfoEndpoint().userService(kakaoOAuth2UserService);
        http.logout().logoutSuccessUrl("/");
    }
}
