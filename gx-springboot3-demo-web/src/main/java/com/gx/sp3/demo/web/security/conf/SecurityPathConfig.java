package com.gx.sp3.demo.web.security.conf;

//import com.gx.web.security.component.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.ProviderManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import java.util.Arrays;
//
///**
// * SpringSecurity相关配置，仅用于配置SecurityFilterChain
// * Created by macro on 2019/11/5.
// */
//@Configuration
//@EnableWebSecurity
//public class SecurityPeakConfig {
//    @Autowired
//    private IgnoreUrlsConfig ignoreUrlsConfig;
//
//    @Autowired
//    private GxAccessDeniedHandler gxAccessDeniedHandler;
//
//    @Autowired
//    private GxAuthenticationEntryPoint restAuthenticationEntryPoint;
//
//    @Autowired
//    private GxAuthenticationTokenFilter jwtAuthenticationTokenFilter;
//
////    @Autowired
////    private GxAuthorizationManager dynamicAuthorizationManager;
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    private AuthenticationProvider authenticationProvider;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
////        AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity.getSharedObject(
////                AuthenticationManagerBuilder.class);
////        authenticationManagerBuilder.userDetailsService(userDetailsService);
////        authenticationManagerBuilder.authenticationProvider(authenticationProvider);
////        System.out.println("SecurityPeakConfig#securityFilterChain userDetailsService=" + userDetailsService + ", authenticationProvider=" + authenticationProvider);
////        AuthenticationManager authenticationManager = authenticationManagerBuilder.build();
//
//        httpSecurity
//                .authorizeHttpRequests((authorize) -> authorize
//                        .requestMatchers(ignoreUrlsConfig.getUrls().stream().toArray(String[]::new)).permitAll()
//                        .requestMatchers(HttpMethod.OPTIONS).permitAll()
//                        .requestMatchers("/test001").hasAuthority("USER")
//                        .requestMatchers("/test002").hasAuthority("ADMIN")
//                        .requestMatchers("/blog/page").hasAuthority("PLAYER")
//                        .anyRequest().authenticated()
//                )
////                .authorizeHttpRequests((authorize) -> authorize
////                        .anyRequest().access(dynamicAuthorizationManager)
////                )
//                .csrf(AbstractHttpConfigurer::disable)
//                .sessionManagement((configurer) -> configurer
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .exceptionHandling((customizer) -> customizer
//                        .authenticationEntryPoint(restAuthenticationEntryPoint)
//                        .accessDeniedHandler(gxAccessDeniedHandler))
//                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
//                .formLogin((form) -> form
//                        .loginPage("/login")
//                        .permitAll()
//                )
//                .logout((logout) -> logout.permitAll());
//        return httpSecurity.build();
//    }
//}
