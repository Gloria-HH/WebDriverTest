package com.demo.data;

import com.demo.param.LoginParameter;

public class LoginData {
    private LoginParameter correctLogin;
    private LoginParameter errorUsername;
    private LoginParameter errorPassword;

    public LoginParameter getCorrectLogin() {
        return correctLogin;
    }

    public void setCorrectLogin(LoginParameter correctLogin) {
        this.correctLogin = correctLogin;
    }

    public LoginParameter getErrorUsername() {
        return errorUsername;
    }

    public void setErrorUsername(LoginParameter errorUsername) {
        this.errorUsername = errorUsername;
    }

    public LoginParameter getErrorPassword() {
        return errorPassword;
    }

    public void setErrorPassword(LoginParameter errorPassword) {
        this.errorPassword = errorPassword;
    }
}
