package com.dhk.login.domain;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "MEMBER")
@Getter
public class Member {

    @Id @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private boolean enabled;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public Member(String username, String password, boolean enabled, Role role) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.role = role;
    }
}
