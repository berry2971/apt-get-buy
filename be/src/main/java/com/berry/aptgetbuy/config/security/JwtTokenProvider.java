package com.berry.aptgetbuy.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class JwtTokenProvider {
    private final String SECRET_KEY = "fltZ7eLZ1eQ66MCeQ2eYh0dGbQI8ITVEgZE6";
    private final String ISSUER = "com.straw.aptgetbuy";
    private final int TOKEN_VALID_HOURS = 24 * 3;

    public String createToken(String id) {
        JWTCreator.Builder builder = JWT.create()
                .withIssuer(ISSUER)
                .withClaim("id", id)
                .withExpiresAt(createExpirationDate(true));
        return builder.sign(Algorithm.HMAC256(SECRET_KEY));
    }

    public String createExpiredToken(String id) {
        JWTCreator.Builder builder = JWT.create()
                .withIssuer(ISSUER)
                .withClaim("id", id)
                .withExpiresAt(createExpirationDate(false));
        return builder.sign(Algorithm.HMAC256(SECRET_KEY));
    }

    public String getIdFromToken(String token) {
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getClaim("id").asString();
    }

    public void verify(String token) throws JWTVerificationException {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SECRET_KEY))
                .withIssuer(ISSUER)
                .build();
        jwtVerifier.verify(token);
    }

    private Date createExpirationDate(boolean alive) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        if (alive) {
            calendar.add(Calendar.HOUR, TOKEN_VALID_HOURS);
        }
        return calendar.getTime();
    }

}
