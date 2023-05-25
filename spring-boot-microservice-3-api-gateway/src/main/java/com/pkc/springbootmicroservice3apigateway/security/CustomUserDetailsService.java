package com.pkc.springbootmicroservice3apigateway.security;

import com.pkc.springbootmicroservice3apigateway.model.User;
import com.pkc.springbootmicroservice3apigateway.service.UserService;
import com.pkc.springbootmicroservice3apigateway.utils.SecurityUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

//YES
@Service
public class CustomUserDetailsService implements UserDetailsService
{
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userService.findByUsername(username).orElseThrow(
            () -> new UsernameNotFoundException("User not found with username: " + username));

        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));

        //        //UserDetails
        //        return UserPrincipal.builder()
        //                .user(user)
        //                .id(user.getId())
        //                .username(username)
        //                .password(user.getPassword())
        //                .authorities(authorities)
        //                .build();

        //UserPrincipal(Long id, String username, String password, User user, Set<GrantedAuthority> authorities)
        //UserDetails - ISSUE Builder is not working 
        return new UserPrincipal(user.getId(), username, user.getPassword(), user, authorities);
    }
}
