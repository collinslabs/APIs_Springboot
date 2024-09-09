package com.example.api_redo.model.response;

public class LoginRes {
    private String email;
    private String token;
    private String roleName;

    public LoginRes(String email, String token, String roleName) {
        this.email = email;
        this.token = token;
        this.roleName = roleName;


    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
