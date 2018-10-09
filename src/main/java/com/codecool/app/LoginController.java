package com.codecool.app;

import java.util.NoSuchElementException;

public class LoginController {
    private LoginView view;
    private Account loggedAccount;
    private boolean isUserLogged;

    public LoginController(LoginView view){
        this.view = view;
        isUserLogged = false;
    }

    public void logIn(){
        loggedAccount = view.getAccount();
        isUserLogged = true;
    }

    public void logOut(){
        isUserLogged = false;
    }

    public Account getLoggedAccount(){
        if (isUserLogged()){
            return loggedAccount;
        }

        throw new NoSuchElementException("");
    }

    public boolean isUserLogged(){
        return isUserLogged();
    }
}
