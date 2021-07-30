package com.dhk.login.security;

import com.dhk.login.domain.Member;
import lombok.Getter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;


@Getter
public class SecurityUser extends User {

    private Member member;

    public SecurityUser(Member member) {
        super(member.getUsername(), member.getPassword(), AuthorityUtils.createAuthorityList(member.getRole().toString()));

        this.member = member;
    }
}