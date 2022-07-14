package com.berry.aptgetbuy.config.security;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Base64;

class JwtTokenProviderTest {

    private static String SECRET_KEY = "fltZ7eLZ1eQ66MCeQ2eYh0dGbQI8ITVEgZE6";

    static {
        SECRET_KEY = Base64.getEncoder().encodeToString(SECRET_KEY.getBytes());
    }

    JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();

    @Test
    void printTokenForTest() {
        String token = jwtTokenProvider.createToken("berry123");
        System.out.println(token);
    }

    @Test
    void printExpiredTokenForTest() {
        String token = jwtTokenProvider.createExpiredToken("berry123");
        System.out.println(token);
    }

    @Test
    void printLengthOfEncodedPassword() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("asdkfkej").length());
        System.out.println(passwordEncoder.encode("asdv3z").length());
        System.out.println(passwordEncoder.encode("baazakjdjfk321fsgjklajakldfz").length());
    }

    @Test
    void init() {
    }

    @Test
    void createToken() {
    }

    @Test
    void createExpiredToken() {
    }

    @Test
    void verify() {
    }

    @Test
    void getIdFromToken() {
    }

}
