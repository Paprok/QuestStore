package com.codecool.app.login;

import com.codecool.app.messages.ErrorMessages;
import com.codecool.app.messages.LoginMessages;
import com.codecool.app.view.LoginView;

import java.util.NoSuchElementException;

public class LoginController {
    private LoginView loginView;
    private ErrorMessages errorMessages;
    private Account loggedAccount;
    private boolean isUserLogged;

    public LoginController(LoginView loginView){
        this.loginView = loginView;
        errorMessages = new ErrorMessages();
        isUserLogged = false;
    }

    public void logIn() throws NoSuchElementException{
        Account userTryingToLogIn = loginView.getAccountInformation();
        loggedAccount = getCorrespondingAccountFromDB(userTryingToLogIn);
        isUserLogged = true;
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

    private Account getCorrespondingAccountFromDB(Account userTryingToLogIn){
        // Get account from DB and return it if exists
        // Set account id

        throw new NoSuchElementException(errorMessages.getUSER_NOT_REGISTERED_MESSAGE());
    }
}
