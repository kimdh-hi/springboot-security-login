package com.dhk.login.security;

import com.dhk.login.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class KakaoOauth2UserService extends DefaultOAuth2UserService {

    private final MemberRepository memberRepository;
    private final HttpSession session;

        @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        Map<String, Object> attributes = oAuth2User.getAttributes();
        session.setAttribute("login_info", attributes);
        log.info("id = {}" ,attributes.get("id"));
        log.info("nickname = {}" ,attributes.get("nickname"));
        log.info("gender = {}" ,attributes.get("gender"));
        log.info("email = {}", attributes.get("email"));
        log.info("age = {}", attributes.get("age"));

        return new DefaultOAuth2User(AuthorityUtils.createAuthorityList("USER"), attributes, "id");
    }
}
