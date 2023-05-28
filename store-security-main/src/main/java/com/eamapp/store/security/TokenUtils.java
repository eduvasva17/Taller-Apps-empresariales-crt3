package com.eamapp.store.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtils {
    private final static String ACCES_TOKEN_SECRET = "ta3KWOz?p8AFxvMw8v/gb-clnaNH!8ftagZ5!ZhN?b6?Ndz5n!f!2xgHGmrJ=!3JNWiLbKmRb7P1Ogq0yNFeQ=Bo4CGe98WjmaLUod=-VsxTxfxXQ-k!5MEp3uPyhUPzlLfv8QsMjP1noQzKKjTUvRk?02?qwCOumqJJTG4-Ryxbf52rglfyL8aqOPhTt9FXAxtNrjaFD!2MIKP!GEb/XG!Fd0/6DAd8H/PAO?Hg11UuMfp4!V?EQbhdmOUcGvzz";
    //(30 days * 24h * 60seconds)
    private final static Long ACCES_TOKEN_VALID_SECOND = 2_592_000L;

    public static String createTokens(String name, String email){
        long expirationTime = ACCES_TOKEN_VALID_SECOND * 1_000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("name", name);

        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCES_TOKEN_SECRET.getBytes()))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCES_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String email = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
        }catch (JwtException e){
            return null;
        }
    }

}
