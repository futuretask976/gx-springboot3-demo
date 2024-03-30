package com.gx.sp3.demo.web.security.component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import java.io.IOException;

public class GxAuthSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException {
        HttpSession session = request.getSession();
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        session.setAttribute("user", authUser);
        session.setAttribute("username", authUser.getUsername());
        session.setAttribute("authorities", authentication.getAuthorities());

        // Set our response to OK status
        response.setStatus(HttpServletResponse.SC_OK);

        // Since we have created our custom success handler, its up to us,
        // to where we will redirect the user after successfully login
        SavedRequest savedRequest = new HttpSessionRequestCache().getRequest(request, response);
        response.sendRedirect(savedRequest.getRedirectUrl().isEmpty() ? "/" : savedRequest.getRedirectUrl()); //requestUrl!=null?requestUrl:
    }
}
