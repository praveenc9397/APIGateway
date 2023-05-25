package com.pkc.springbootmicroservice3apigateway.service;

import com.pkc.springbootmicroservice3apigateway.model.User;

public interface AuthenticationService
{
    User signInAndReturnJWT(User signInRequest);
}
