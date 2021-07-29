package com.dhk.login.security;

import com.dhk.login.domain.Member;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

@Slf4j
@Getter @Setter
public class SecurityUser extends User {

    private Member member;

    public SecurityUser(Member member) {
        super(member.getUsername(), member.getPassword(), AuthorityUtils.createAuthorityList(member.getRole().toString()));

        log.info("SecurityUser member.username = {}", member.getUsername());
        log.info("SecurityUser member.password = {}", member.getPassword());
        log.info("SecurityUser member.role = {}", member.getRole().toString());

        this.member = member;
    }

}
