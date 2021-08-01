package com.dhk.login.jwt;

public interface JwtService {

    String createToken(String subject, Long ttl);

    String getSubject(String token);

    void isValid(String token) throws Exception;
}
