package com.auth.auth_app.Utils;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JWTUtils {
        private final long Expiration_Time = 1000 * 60 * 60;
        private final String Sectet = " MySuperSecretKeyForJwtSigning2026!";
        private final SecretKey Key =  Keys.hmacShaKeyFor(Sectet.getBytes());

        public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + Expiration_Time))
                .signWith(Key, SignatureAlgorithm.HS256)
                .compact();
        }

}
