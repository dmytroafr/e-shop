//package com.e_chem.internet_shop.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity()
//public class SecurityConfig {
//
//    @Bean
//    protected SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
//
//        http.authorizeHttpRequests(
//                        requests -> requests
//                                .requestMatchers("/admin").authenticated()
//                                .requestMatchers("/products").permitAll()
//                                .anyRequest().permitAll()
//
//                );
//
//        return http.build();
//    }
//}
