package com.codecool.app.login;

import com.codecool.app.view.LoginView;

import java.util.NoSuchElementException;

public class LoginController {
    private final String USER_NOT_LOGGED_ERROR = "No user is logged in";
    private final String USER_NOT_REGISTERED_ERROR = "Entered nickname and passwords doesn\'t matches";

    private LoginView loginView;
    private Account loggedAccount;
    private boolean isUserLogged;

    public LoginController(LoginView loginView){
        this.loginView = loginView;
        isUserLogged = false;
    }

    public void logIn() throws NoSuchElementException{
        Account userTryingToLogIn = loginView.getAccount();
        Account accountWithCorrespondingNicknameInDB
                = getAccountWithCorrespondingNicknameFromDB(userTryingToLogIn.getNickname());

        if (isPasswordValid(userTryingToLogIn, accountWithCorrespondingNicknameInDB)){
            loggedAccount = accountWithCorrespondingNicknameInDB;
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

    private Account getAccountWithCorrespondingNicknameFromDB(String nickname){
        // Get account from DB and return it if exists

        throw new NoSuchElementException(USER_NOT_REGISTERED_ERROR);
    }

    private boolean isPasswordValid(Account userTryingToLigIn, Account accountWithCorrespondingNickname){
        return userTryingToLigIn.getPassword().equals(accountWithCorrespondingNickname.getPassword());
    }
}
