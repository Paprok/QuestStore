package com.codecool.app;

import com.codecool.app.login.Account;
import com.codecool.app.login.LoginController;
import com.codecool.app.usercontrollers.*;
import com.codecool.app.view.QSView;
import com.codecool.app.view.consoleimpl.LoginViewConsoleImpl;

import java.util.NoSuchElementException;

public class QuestStore {
    private final String[] MENU_OPTIONS = {"Login", "Exit"};
    private final String NO_ACCESS_ERROR = "Controller for user with given access level is not implemented";
    private QSView view;

    public QuestStore(QSView view){
        this.view = view;
    }

    public void run(){
        boolean isRunning = true;
        String choice;

        while (isRunning){
            view.printMenu(MENU_OPTIONS);

            choice = view.getInput();
            switch (choice){
                case "1":
                    logInAndRunControllerForUser();
                    break;
                case "2":
                    isRunning = false;
                    break;
            }
        }
    }

    private void logInAndRunControllerForUser(){
        LoginController loginController = new LoginController(new LoginViewConsoleImpl());

        try{
            loginController.logIn();
        } catch (NoSuchElementException e){
            view.printError(e.getMessage());
            return;
        }

        try{
            UserController userController = getControllerForUser(loginController.getLoggedAccount());
            userController.run();
        } catch (IllegalAccessException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private UserController getControllerForUser(Account loggedUser) throws IllegalAccessException{
        switch (loggedUser.getAccessLevel()){
            case ADMIN:
                return new AdminController();
            // case MENTOR
            // case CODECOOLER
        }

        throw new IllegalAccessException(NO_ACCESS_ERROR);
    }
}
