package com.system.hotelmanagement.springsecurity;

import java.io.IOException;
import java.util.Collection;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        String redirectUrl = "/hotelmanagementsystem/login"; // fallback

        for (GrantedAuthority authority : authorities) {
            String role = authority.getAuthority();
            if (role.equals("ROLE_ADMIN")) {
                redirectUrl = "/hotelmanagementsystem/admin/dashboard";
                break;
            } else if (role.equals("ROLE_CUSTOMER")) {
                redirectUrl = "/hotelmanagementsystem/customer/dashboard";
                break;
            }
        }

        response.sendRedirect(redirectUrl);
    }
}

