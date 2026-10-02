package com.engine.calculator.services;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    @Value("${spring.security.jwt.secret}")
    private String secretKey;

    @Value("${spring.security.jwt.expiration}")
    private long expiration;

    //Tranformar String a chave em Json Web Token
    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    //Método para gerar token
    public String generateToken(UserDetails userDetails) {

        Date now = new Date();

        Date expirationDate = new Date(now.getTime() + expiration);


        /*
        Configs:
        1. Quem é esse usuário = .subject
        2. Quando foi criado = .issuedAt
        3. Quando expira = .expiration
        4. Assinar o token = .signWith
        5. Transformar tudo em String = .compact
         */
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(now)
                .expiration(expirationDate)
                .signWith(getSigningKey())
                .compact();
    }

    public String exctractUsername(String token) {

        return extractAllClaims(token).getSubject();

    }

    //Verificar se o token é válido
    public boolean isTokenValid(String token, UserDetails userDetails) {
        String username = exctractUsername(token);

        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);

    }

    //Verificar se o token está expirado
    public boolean isTokenExpired(String token){

        return extractAllClaims(token)
                .getExpiration()
                .before(new Date());

    }

    //Leitor de claims
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }




}
