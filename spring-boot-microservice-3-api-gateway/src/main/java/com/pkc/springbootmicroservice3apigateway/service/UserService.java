package com.pkc.springbootmicroservice3apigateway.service;

import java.util.Optional;

import com.pkc.springbootmicroservice3apigateway.model.Role;
import com.pkc.springbootmicroservice3apigateway.model.User;

//YES
public interface UserService
{
    User saveUser(User user);

    Optional<User> findByUsername(String username);

    void changeRole(Role newRole, String username);
}
