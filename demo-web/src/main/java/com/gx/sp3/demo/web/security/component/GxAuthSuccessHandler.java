package com.gx.sp3.demo.web.security.component;

import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import java.io.IOException;

public class GxAuthSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException {
        System.out.printf("!!! GxAuthSuccessHandler#onAuthenticationSuccess entering\n");
        HttpSession session = request.getSession();
        UserDetails authUser = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        session.setAttribute("user", authUser);
        session.setAttribute("username", authUser.getUsername());
        session.setAttribute("authorities", authentication.getAuthorities());

        // Set our response to OK status
        response.setStatus(HttpServletResponse.SC_OK);

        // 如果是前后端分离项目，这里可以返回JSON字符串提示前端登录成功
        JSONObject responseBody = new JSONObject();
        responseBody.put("loginSuccess", "true");
        response.getWriter().println(responseBody.toJSONString());
        response.flushBuffer();
        // 如果不是前后端分离项目，这里返回/welcome渲染thymeleaf模板
        // Since we have created our custom success handler, its up to us,
        // to where we will redirect the user after successfully login
        // SavedRequest savedRequest = new HttpSessionRequestCache().getRequest(request, response);
        // response.sendRedirect(savedRequest == null || savedRequest.getRedirectUrl().isEmpty() ? "/welcome" : savedRequest.getRedirectUrl()); //requestUrl!=null?requestUrl:
    }
}
