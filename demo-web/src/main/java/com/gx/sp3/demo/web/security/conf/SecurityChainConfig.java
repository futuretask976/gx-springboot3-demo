package com.gx.sp3.demo.web.security.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.util.stream.Collectors;

/**
 * SpringSecurity相关配置，仅用于配置SecurityFilterChain
 * Created by macro on 2019/11/5.
 */
@Configuration
@EnableWebSecurity
public class SecurityChainConfig {
    @Autowired
    private IgnoreUrlsConfig ignoreUrlsConfig;

    @Autowired
    private AccessDeniedHandler gxAccessDeniedHandler;

    @Autowired
    private AuthenticationEntryPoint gxAuthenticationEntryPoint;

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        System.out.printf("!!! SecurityChainConfig#filterChain ignoreUrlsConfig=%s\n"
                , ignoreUrlsConfig.getUrls() == null ? null : ignoreUrlsConfig.getUrls().stream().collect(Collectors.joining(", ")));

        httpSecurity
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll())
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers(ignoreUrlsConfig.getUrls().stream().toArray(String[]::new)).permitAll()
                        .requestMatchers(HttpMethod.OPTIONS).permitAll()
                        .requestMatchers("/test002").hasAuthority("USER")
                        .requestMatchers("/test003").hasAuthority("ADMIN")
                        .anyRequest().authenticated()
                )
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement((configurer) -> configurer
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling((customizer) -> customizer
                        .authenticationEntryPoint(gxAuthenticationEntryPoint)
                        .accessDeniedHandler(gxAccessDeniedHandler));
        return httpSecurity.build();
    }
}
