package com.demoDigital.demo.customModel;

import lombok.Data;

import com.demoDigital.demo.model.User;

@Data
public class AuthResponse {

    private User user;
    private String token;

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
