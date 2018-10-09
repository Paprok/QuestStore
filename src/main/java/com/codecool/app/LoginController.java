package com.codecool.app;

import java.util.NoSuchElementException;

public class LoginController {
    private final String USER_NOT_LOGGED_ERROR = "No user is logged in";

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
        if (isUserLogged){
            return loggedAccount;
        }

        throw new NoSuchElementException(USER_NOT_LOGGED_ERROR);
    }
}
