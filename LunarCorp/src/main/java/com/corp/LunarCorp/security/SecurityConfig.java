package com.corp.LunarCorp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/usuario", "/usuario-tecnico", "/api/usuario-tecnico", "/tecnico", "/chamado", "/api/chamado").permitAll()
                        .requestMatchers("**").permitAll()// libera cadastro
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults()); // usa autenticação básica para testes com Postman

        return http.build();
    }
}