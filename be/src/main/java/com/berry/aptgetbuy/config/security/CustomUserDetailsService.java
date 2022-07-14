package com.berry.aptgetbuy.config.security;

import com.berry.aptgetbuy.domain.entity.User;
import com.berry.aptgetbuy.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserMapper userMapper;

    @Autowired
    public CustomUserDetailsService(
            UserMapper userMapper
    ) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        User user = userMapper.findById(id);
        if (user == null) {
            log.info("ID에 해당하는 사용자를 찾을 수 없습니다.");
            throw new UsernameNotFoundException("ID에 해당하는 사용자를 찾을 수 없습니다.");
        }
        CustomUserDetails userDetails = new CustomUserDetails(user);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        userDetails.setAuthorities(authorities);
        return userDetails;
    }

}
