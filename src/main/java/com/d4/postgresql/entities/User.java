package com.d4.postgresql.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "users")
public class User implements Serializable {

    public User() {}

    public User(User copy) {
        this.id = copy.getId();
        this.username = copy.getUsername();
        this.password = copy.getPassword();
        this.email = copy.getEmail();
        this.oauth = copy.isOauth();
        this.token = copy.getToken();
        this.expiration = copy.getExpiration();
    }

    @Id
    private String id;

    @Column(name="username")
    private String username;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name="password")
    private String password;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name="email")
    private String email;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name="oauth")
    private Boolean oauth;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name="token")
    private String token;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name="expiration")
    private Instant expiration;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean isOauth() {
        return oauth;
    }

    public void setOauth(Boolean oauth) {
        this.oauth = oauth;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Instant getExpiration() {
        return expiration;
    }

    public void setExpiration(Instant expiration) {
        this.expiration = expiration;
    }
}