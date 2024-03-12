//package com.e_chem.internet_shop.config;
//
//import com.e_chem.internet_shop.domain.Role;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
//import org.springframework.security.web.csrf.XorCsrfTokenRequestAttributeHandler;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@EnableWebSecurity()
//public class SecurityConfig {
//    private final UserDetailsService userDetailsService;
//
//    public SecurityConfig(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    protected SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
//
//        return http.authorizeHttpRequests(
//                        requests -> requests
//                                .anyRequest()
//                                .permitAll())
//                .userDetailsService(userDetailsService)
//
//
//                .formLogin((form) -> form
//                        .permitAll()
//                        .failureUrl("/login-error")
//                        .loginProcessingUrl("/auth"))
//
//                .logout((logout) -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                        .logoutSuccessUrl("/").deleteCookies("JSESSIONID")
//                        .invalidateHttpSession(true))
//
//                .csrf((csrf) -> csrf
//                        .csrfTokenRequestHandler(new XorCsrfTokenRequestAttributeHandler())
//                        .csrfTokenRepository(new HttpSessionCsrfTokenRepository()))
//
//                .build();
//    }
//}
