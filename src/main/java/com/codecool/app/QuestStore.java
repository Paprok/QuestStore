package com.codecool.app;

import java.util.NoSuchElementException;

public class QuestStore {
    private final String[] MENU_OPTIONS = {"Login", "Exit"};
    private QSView view;
    private LoginController loginController;

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
                    logIn();
                    break;
                case "2":
                    isRunning = false;
                    break;
            }
        }
    }

    private void logIn(){
        LoginController loginController = new LoginController(new LoginViewConsoleImp());
        try{
            loginController.logIn();
            // TO DO
            // Run controller for logged user
        } catch (NoSuchElementException e){
            view.printError(e.getMessage());
        }
    }
}
