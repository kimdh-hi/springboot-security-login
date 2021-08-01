package com.dhk.login;

import com.dhk.login.domain.Member;
import com.dhk.login.domain.Role;
import com.dhk.login.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class LoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();

	}

	@Autowired
	private MemberRepository memberRepository;

	@PostConstruct
	public void memberInit() {
		Member member = new Member("member", "123", Role.ROLE_MEMBER);
		Member admin =  new Member("admin", "123", Role.ROLE_ADMIN);
		Member manager = new Member("manager", "123", Role.ROLE_MANAGER);
		memberRepository.saveAll(List.of(member, admin, manager));
	}

}
