package com.example.springsecurity_java.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AuthenticationConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .httpBasic(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                // .requestMatchers("/api/v1/users/join", "/api/v1/users/login").permitAll()
                // .requestMatchers(HttpMethod.POST, "/api/v1/**").authenticated()
                .authorizeHttpRequests(
                        r -> r.requestMatchers("/api/v1/users/join", "/api/v1/users/login").permitAll() // 특정 url 체크 제외
                                .requestMatchers(HttpMethod.POST, "/api/v1/**").authenticated() // 그 Post형식 및  url은 인증이 되어야함
                )
                // .and()
                // .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .sessionManagement(c -> c.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // .and();
                // TODO
                //.addFilterBefore()
                ;

        return httpSecurity.build();
    }
}
