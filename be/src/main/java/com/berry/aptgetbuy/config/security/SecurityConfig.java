package com.berry.aptgetbuy.config.security;

import com.berry.aptgetbuy.domain.entity.EnumRole;
import com.berry.aptgetbuy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtAuthTokenFilter jwtAuthTokenFilter;
    private final UserMapper userMapper;

    @Autowired
    public SecurityConfig(
            JwtAuthTokenFilter jwtAuthTokenFilter,
            UserMapper userMapper
    ) {
        this.jwtAuthTokenFilter = jwtAuthTokenFilter;
        this.userMapper = userMapper;
    }

    private static final String[] AUTH_PERMIT_LIST = {
            // Swagger UI v2
            "/v2/api-docs/",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "swagger-ui.html",
            "/webjars/**",
            // Swagger UI v3
            "/v3/api-docs/**",
            "/swagger-ui/**",
            // static resources
            "/img/**",
            // login
            "/users/auth/**",
            // deal
            "/deals/**",
            "/districts/**",
            // complex
            "/complex/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http = http.cors().and().csrf().disable();

        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http
                .exceptionHandling()
                .authenticationEntryPoint((request, response, e) -> {
                    response.sendError(
                            HttpServletResponse.SC_UNAUTHORIZED,
                            e.getMessage()
                    );
                });

        http
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole(EnumRole.ADMIN.name())
                .antMatchers(AUTH_PERMIT_LIST).permitAll()
                .anyRequest().hasRole(EnumRole.USER.name());

        http.addFilterBefore(jwtAuthTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedOriginPattern("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username -> {
            try {
                return new CustomUserDetails(userMapper.findById(username));
            } catch (Exception e) {
                throw new UsernameNotFoundException("찾을 수 없습니다.");
            }
        });
    }

    @Bean
    public PasswordEncoder passwordEncoderBean() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
