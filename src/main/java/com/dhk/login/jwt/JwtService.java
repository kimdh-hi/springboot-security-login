package com.dhk.login.controller.jwt;

public interface JwtService {

    String createToken(String subject, Long ttl);

    String getSubject(String token);

    void isValid(String token) throws Exception;
}
