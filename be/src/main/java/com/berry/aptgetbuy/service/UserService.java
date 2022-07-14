package com.berry.aptgetbuy.service;

import com.berry.aptgetbuy.mapper.UserMapper;
import com.berry.aptgetbuy.config.security.JwtTokenProvider;
import com.berry.aptgetbuy.domain.entity.User;
import com.berry.aptgetbuy.mapper.BlacklistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    private final UserMapper userMapper;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final BlacklistMapper blacklistMapper;

    @Autowired
    public UserService(
            UserMapper userMapper,
            JwtTokenProvider jwtTokenProvider,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            BlacklistMapper blacklistMapper
    ) {
        this.userMapper = userMapper;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.blacklistMapper = blacklistMapper;
    }

    public User getUser(String id) throws Exception {
        return userMapper.findById(id);
    }

    public User registerUser(User user) throws Exception {
        user.setPw(getEncodedPasswordFromRawPassword(user.getPw()));
        user.setRole("ROLE_USER");
        userMapper.save(user);
        return user;
    }

    public User modifyUser(User user) throws Exception {
        user.setPw(getEncodedPasswordFromRawPassword(user.getPw()));
        user.setRole("ROLE_USER");
        userMapper.modifyUser(user);
        return user;
    }

    public String login(String id, String pw) throws Exception {
        blacklistMapper.remove(id);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(id, pw)
        );
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        String token = jwtTokenProvider.createToken(userDetails.getUsername());
        return token;
    }

    public String getEncodedPasswordFromRawPassword(String password) {
        return passwordEncoder.encode(password);
    }

}
