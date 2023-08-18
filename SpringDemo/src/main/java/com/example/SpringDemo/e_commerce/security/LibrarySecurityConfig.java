package com.example.SpringDemo.e_commerce.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class LibrarySecurityConfig {
    private static final String[] SECURED_URLs = {"/api/v1/**"};
    private static final String[] UNSECURED_URLs = {"/api/v1/users"};
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {



        return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(new AntPathRequestMatcher(String.join(",", UNSECURED_URLs))).permitAll().and()
                .authorizeHttpRequests().requestMatchers(new AntPathRequestMatcher(String.join(",", SECURED_URLs))).hasAuthority("ADMIN").anyRequest()
                .authenticated().and().httpBasic().and().build();

    }
}
