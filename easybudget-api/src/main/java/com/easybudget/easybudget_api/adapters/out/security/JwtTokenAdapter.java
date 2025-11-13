package com.easybudget.easybudget_api.adapters.out.security;

import com.easybudget.easybudget_api.config.JwtProperties;
import com.easybudget.easybudget_api.domain.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenAdapter {

    private final JwtProperties jwtProperties; 
    private final Key signingKey;

    public JwtTokenAdapter(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
        
        byte[] keyBytes = Decoders.BASE64.decode(this.jwtProperties.getSecret());
        this.signingKey = Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExpirationMs()))
                .signWith(this.signingKey, SignatureAlgorithm.HS256)
                .compact();
    }

}