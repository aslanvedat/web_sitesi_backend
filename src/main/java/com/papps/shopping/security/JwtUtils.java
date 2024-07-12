package com.papps.shopping.security;

import com.papps.shopping.share.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author : Onur TALANTIMUR
 * @mailto : onurta@netas.com.tr
 * @created : 12.07.2024, Friday
 **/

@Component
public class JwtUtils {

    private final SecretKey key;

    @Value("${security.jwt.refresh-token-expiry}")
    private int refreshTokenExpirySeconds;

    public JwtUtils() {
        this.key = Keys.hmacShaKeyFor(generateToken());

    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(Constants.JWT.AUTHORITIES_CLAIM, userDetails.getAuthorities());
        return createToken(claims, userDetails.getUsername());
    }

    public boolean validateToken(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }


    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }


    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    /**
     * Generate randomly JWT key
     *
     * @return Base64 encoded key
     */
    private byte[] generateToken() {
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance(Constants.JWT.KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Jwt algorithm not found!", e);
        }
        keyGenerator.init(Constants.JWT.KEY_SIZE);
        SecretKey key = keyGenerator.generateKey();
        return key.getEncoded();
    }

    private String createToken(Map<String, Object> claims, String username) {
        return Jwts.builder().claims(claims).subject(username).issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() * 1000 * refreshTokenExpirySeconds))
                .signWith(key).compact();
    }


}
