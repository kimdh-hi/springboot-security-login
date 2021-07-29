package com.dhk.login.repository;

import com.dhk.login.domain.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {

    Optional<Member> findByUsername(String username);
}
