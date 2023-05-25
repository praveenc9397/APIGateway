package com.pkc.springbootmicroservice3apigateway.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.pkc.springbootmicroservice3apigateway.model.User;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Transient;

//YES
public class UserPrincipal implements UserDetails
{
    private Long id;
    String username;
    private String password; //don't show up on serialized places.
    private User user; //user for only login operation, don't use in JWT.
    private Set<GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return authorities;
    }

    public UserPrincipal()
    {
        super();
    }

    public UserPrincipal(Long id, String username, String password, User user, Set<GrantedAuthority> authorities)
    {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.user = user;
        this.authorities = authorities;
    }

    @Override
    public String getPassword()
    {
        return password;
    }

    @Override
    public String getUsername()
    {
        return username;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setAuthorities(Set<GrantedAuthority> authorities)
    {
        this.authorities = authorities;
    }

    @Override
    public String toString()
    {
        return "UserPrincipal [id=" + id + ", username=" + username + ", password=" + password + ", user=" + user
            + ", authorities=" + authorities + ", getAuthorities()=" + getAuthorities() + ", getPassword()="
            + getPassword() + ", getUsername()=" + getUsername() + ", isAccountNonExpired()=" + isAccountNonExpired()
            + ", isAccountNonLocked()=" + isAccountNonLocked() + ", isCredentialsNonExpired()="
            + isCredentialsNonExpired() + ", isEnabled()=" + isEnabled() + ", getId()=" + getId() + ", getUser()="
            + getUser() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
            + super.toString() + "]";
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(authorities, id, password, user, username);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserPrincipal other = (UserPrincipal) obj;
        return Objects.equals(authorities, other.authorities) && Objects.equals(id, other.id)
            && Objects.equals(password, other.password) && Objects.equals(user, other.user)
            && Objects.equals(username, other.username);
    }

}
