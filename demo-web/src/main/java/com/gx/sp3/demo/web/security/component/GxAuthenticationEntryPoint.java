package com.gx.sp3.demo.web.security.component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

/**
 * 自定义未登录或者token失效时的返回结果
 */
public class GxAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException e) throws IOException {
        System.out.printf("!!! GxAccessDeniedHandler#handle entering: %s， %s\n", e.getMessage(), e.toString());
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Cache-Control","no-cache");
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json");
//        response.getWriter().println("广夏：未经过认证，" + e.getMessage());
//        response.getWriter().flush();

        // 设置状态码为302
        response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
        // 设置Location头部，指定重定向的URL
        response.setHeader("Location", "/gxsp3demo/login");
    }
}
