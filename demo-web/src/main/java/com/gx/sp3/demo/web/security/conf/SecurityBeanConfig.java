package com.gx.sp3.demo.web.security.conf;

import com.gx.sp3.demo.web.security.component.GxAccessDeniedHandler;
import com.gx.sp3.demo.web.security.component.GxAuthSuccessHandler;
import com.gx.sp3.demo.web.security.component.GxAuthenticationEntryPoint;
import com.gx.sp3.demo.web.security.encoder.MD5PasswordEncoder;
import com.gx.sp3.demo.web.security.service.GxUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class SecurityBeanConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        System.out.printf("!!! SecurityBaseConfig#passwordEncoder entering\n");
        return new MD5PasswordEncoder();
    }

    @Bean
    public IgnoreUrlsConfig ignoreUrlsConfig() {
        System.out.printf("!!! SecurityBaseConfig#ignoreUrlsConfig entering\n");
        return new IgnoreUrlsConfig();
    }

    @Bean
    public AccessDeniedHandler restfulAccessDeniedHandler() {
        System.out.printf("!!! SecurityBaseConfig#restfulAccessDeniedHandler entering\n");
        return new GxAccessDeniedHandler();
    }

    @Bean
    public AuthenticationEntryPoint restfulAuthenticationEntryPoint() {
        System.out.printf("!!! SecurityBaseConfig#restAuthenticationEntryPoint entering\n");
        return new GxAuthenticationEntryPoint();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        System.out.printf("!!! SecurityBaseConfig#userDetailsService entering\n");
        return new GxUserDetailService();
    }

    @Bean
    public AuthenticationSuccessHandler authSuccessHandler() {
        return new GxAuthSuccessHandler();
    }

//    @Bean
//    public JwtTokenHelper jwtTokenUtil() {
//        System.out.printf("!!! SecurityBaseConfig#jwtTokenUtil entering\n");
//        return new JwtTokenHelper();
//    }

//    @Bean
//    public GxAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
//        System.out.printf("!!! SecurityBaseConfig#jwtAuthenticationTokenFilter entering\n");
//        return new GxAuthenticationTokenFilter();
//    }

//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        System.out.printf("!!! SecurityBaseConfig#authenticationProvider entering\n");
//        return new GxAuthenticationProvider();
//    }
}
