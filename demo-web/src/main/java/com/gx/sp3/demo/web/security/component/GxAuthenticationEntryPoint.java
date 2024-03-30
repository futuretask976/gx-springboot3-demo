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
        // 设置状态码为302
        response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
        // 设置Location头部，指定重定向的URL
        response.setHeader("Location", request.getContextPath() + "/login");
    }
}
