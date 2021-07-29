package com.dhk.login.domain;

import com.dhk.login.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class MemberTest {

    @Autowired MemberRepository memberRepository;
    @Autowired BCryptPasswordEncoder passwordEncoder;

    @Test
    void saveTest() {
        Member member1 = Member.builder()
                .username("memberA")
                .password(passwordEncoder.encode("12314"))
                .role(Role.ROLE_ADMIN)
                .build();
        Member savedMember = memberRepository.save(member1);

        Assertions.assertThat(savedMember.getUsername()).isEqualTo(member1.getUsername());
    }
}