package com.dhk.login.security;

import com.dhk.login.jwt.JwtServiceImpl;
import com.dhk.login.domain.Member;
import com.dhk.login.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final JwtServiceImpl jwtService;
    private final HttpServletResponse response;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("존재하지 않는 username 입니다."));

        String token = jwtService.createToken(username, 60 * 1000L);
        log.info("loadUserByUsername token = {}", token);
        response.setHeader("Authorization", token);

        return new UserDetails(member);
    }
}
