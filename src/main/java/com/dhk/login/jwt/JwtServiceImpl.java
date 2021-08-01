package com.dhk.login.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.util.Date;

@Slf4j
@Service
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Override
    public String createToken(String subject, Long ttl) {

        if (ttl <= 0) throw new RuntimeException("Token is expired"); // 만료된 토큰

        SignatureAlgorithm hs256 = SignatureAlgorithm.HS256; // 서명 알고리즘 지정 HS256
        byte[] encodedSecret = DatatypeConverter.parseBase64Binary(secret);// secret key 를 Base64로 인코딩
        SecretKeySpec signKey = new SecretKeySpec(encodedSecret, hs256.getJcaName());

        return Jwts.builder()
                .setSubject(subject)
                .signWith(hs256, signKey)
                .setExpiration(new Date(System.currentTimeMillis() + ttl))
                .compact();
    }

    @Override
    public String getSubject(String token) {
        return Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(secret))
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    @Override
    public void isValid(String token) throws Exception {
        Jws<Claims> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
        log.info("isValid claims = {}", claims.toString());
    }
}
