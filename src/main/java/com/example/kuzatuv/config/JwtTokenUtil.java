package com.example.kuzatuv.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtTokenUtil {

    private final String jwtSecret = "yourSecretKey";  // JWT sirlilik kaliti

    // Token yaratish
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))  // 1 soat davomida amal qiladi
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    // Tokenni validatsiya qilish
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;  // Agar xato bo‘lsa, token noto‘g‘ri
        }
    }

}
