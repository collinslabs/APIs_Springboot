package com.example.api_redo.model.request;

public class LoginReq {
    private String email;
    private String password;
    private  String roleName;

    public LoginReq(String email, String password, String roleName) {
        this.email = email;
        this.password = password;
        this.roleName = roleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
