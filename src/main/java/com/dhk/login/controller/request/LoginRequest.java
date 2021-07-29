package com.dhk.login.controller.request;

import com.dhk.login.domain.Role;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginRequest {

    private String username;

    private String password;

    private Role role;
}
