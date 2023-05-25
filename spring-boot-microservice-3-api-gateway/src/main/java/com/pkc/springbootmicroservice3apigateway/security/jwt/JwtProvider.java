package com.pkc.springbootmicroservice3apigateway.security.jwt;

import org.springframework.security.core.Authentication;

import com.pkc.springbootmicroservice3apigateway.security.UserPrincipal;

import javax.servlet.http.HttpServletRequest;

public interface JwtProvider
{
    String generateToken(UserPrincipal auth);

    Authentication getAuthentication(HttpServletRequest request);

    boolean isTokenValid(HttpServletRequest request);
}
