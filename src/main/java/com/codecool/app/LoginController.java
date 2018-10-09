package com.codecool.app;

import java.util.NoSuchElementException;

public class LoginController {
    private final String USER_NOT_LOGGED_ERROR = "No user is logged in";
    private final String USER_NOT_REGISTERED_ERROR = "Entered nickname and passwords doesn\'t match";

    private LoginView loginView;
    private Account loggedAccount;
    private boolean isUserLogged;

    public LoginController(LoginView loginView){
        this.loginView = loginView;
        isUserLogged = false;
    }

    public void logIn(){
        Account userTryingToLogIn = loginView.getAccount();
        if (isAccountRegistered(userTryingToLogIn)){
            loggedAccount = userTryingToLogIn;
            isUserLogged = true;
        } else {
            throw new NoSuchElementException(USER_NOT_REGISTERED_ERROR);
        }
    }

    public void logOut(){
        isUserLogged = false;
    }

    public boolean isUserLogged(){
        return isUserLogged;
    }

    public Account getLoggedAccount(){
        return loggedAccount;
    }

    private boolean isAccountRegistered(Account account){
        // TO DO
        // Check if account really exist in database
        // Set account access level due to data in database
        return false;
    }
}
