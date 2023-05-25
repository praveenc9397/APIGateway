package com.pkc.springbootmicroservice3apigateway.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

//YES
@Entity
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true, nullable = false, length = 100)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Transient
    private String token;

    public User()
    {
        super();
    }

    public User(Long id, String username, String password, String name, LocalDateTime createTime, Role role,
        String token)
    {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.createTime = createTime;
        this.role = role;
        this.token = token;
    }

    @Override
    public String toString()
    {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name
            + ", createTime=" + createTime + ", role=" + role + ", token=" + token + ", getClass()=" + getClass()
            + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(createTime, id, name, password, role, token, username);
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
        User other = (User) obj;
        return Objects.equals(createTime, other.createTime) && Objects.equals(id, other.id)
            && Objects.equals(name, other.name) && Objects.equals(password, other.password) && role == other.role
            && Objects.equals(token, other.token) && Objects.equals(username, other.username);
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDateTime getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime)
    {
        this.createTime = createTime;
    }

    public Role getRole()
    {
        return role;
    }

    public void setRole(Role role)
    {
        this.role = role;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

}
