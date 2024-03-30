package com.gx.sp3.demo.web.security.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

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

    @Autowired
    private AuthenticationSuccessHandler gxAuthSuccessHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // We are disabling CSRF so that our forms don't complain about a CSRF token.
        // Beware that it can create a security vulnerability
        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
                // Here we are configuring our login form
                .formLogin(formLogin -> {
                        formLogin
                                .loginPage("/login") // Login page will be accessed through this endpoint. We will create a controller method for this.
                                .loginProcessingUrl("/login-processing") // This endpoint will be mapped internally. This URL will be our Login form post action.
                                .usernameParameter("username")
                                .passwordParameter("password")
                                .permitAll() // We re permitting all for login page
                                .successHandler(gxAuthSuccessHandler) // .defaultSuccessUrl("/welcome") // If the login is successful, user will be redirected to this URL.
                                .failureUrl("/login?error=true"); // If the user fails to login, application will redirect the user to this endpoint
                })
                .authorizeHttpRequests(authorize ->
                        authorize
                                // We are permitting all static resources to be accessed publicly
                                .requestMatchers(ignoreUrlsConfig.getUrls().stream().toArray(String[]::new)).permitAll()
                                // We are restricting endpoints for individual roles.
                                // Only users with allowed roles will be able to access individual endpoints.
                                .requestMatchers("/test002").hasRole("USER")
                                .requestMatchers("/test003").hasAnyRole("USER", "ADMIN")
                                .requestMatchers("/test004").hasAnyRole("ADMIN")
                                // Following line denotes that all requests must be authenticated.
                                // Hence, once a request comes to our application, we will check if the user is authenticated or not.
                                .anyRequest().authenticated()
                )
                .logout(logout ->
                        logout
                                .logoutUrl("/logout")
                                .logoutSuccessUrl("/bye")
                )
                .exceptionHandling(customizer -> customizer
                        .authenticationEntryPoint(gxAuthenticationEntryPoint)
                        .accessDeniedHandler(gxAccessDeniedHandler))
                .build();
    }
}
