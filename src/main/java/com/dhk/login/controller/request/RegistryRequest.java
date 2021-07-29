package com.dhk.login.controller.request;

import com.dhk.login.domain.Role;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RegistryRequest {

    private String username;

    private String password;

    private Role role = Role.ROLE_MEMBER;
}
