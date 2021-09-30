package com.hackathon.amazoneclone.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author danyls ngongang
 * @Created 13/09/2021-11:25
 * @Project user-service
 */
@Service
public class JWTUtils {
    // secret to generate the token
    private final String JWT_SECRET="1cc964e09806fc3fb97c24086e4baad5";
    // validity of the token
    private final long JWT_EXPIRATION_DURATION = 1000*60*60*6;

    public String generateToken(String userEmail){
        Map<String, Object> claims = new HashMap<>();
        return  createToken(claims, userEmail);
    }

    private String createToken(Map<String,Object> claims, String userName){
        return Jwts.builder().setClaims(claims).setSubject( userName ).setIssuedAt( new Date() )
                .setExpiration( new Date(System.currentTimeMillis() + JWT_EXPIRATION_DURATION))
                .signWith(SignatureAlgorithm.HS256, JWT_SECRET)
                .compact();
    }

    public boolean validateToken(String jwt, UserDetails userDetails){
        final String jsonSubject = extractSubject(jwt);
        return jsonSubject!=null && !jsonSubject.isEmpty() && userDetails.getUsername().equals(jsonSubject) && isExpired(jwt);
    }

    private Object extractClaims(String jwt) {
        return  Jwts.parser().parse(jwt).getBody();
    }

    private <T> T extractClaim(String token, Function<Claims,T> clainResolver){
        final  Claims claims = (Claims)extractClaims(token);
        return clainResolver.apply(claims);
    }

    public String extractSubject(String token){
        return extractClaim(token,Claims::getSubject);
    }

    private Date extractExpirationDate(String token){
        return  extractClaim(token,Claims::getExpiration);
    }

    private boolean isExpired(String token){
        Date date = extractExpirationDate(token);
        return !date.before( new Date());
    }

    public long getExpirationDuration(){
        return  JWT_EXPIRATION_DURATION;
    }
}
