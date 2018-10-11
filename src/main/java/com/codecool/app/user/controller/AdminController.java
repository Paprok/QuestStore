package com.codecool.app.user.controller;

import com.codecool.app.dao.AppDAOs;
import com.codecool.app.login.Account;
import com.codecool.app.messages.ErrorMessages;
import com.codecool.app.user.model.Mentor;
import com.codecool.app.user.view.AdminView;

import java.util.NoSuchElementException;

public class AdminController implements UserController{
    private final String[] ADMIN_OPTIONS = {"Create new account", "Exit"};
    private ErrorMessages errorMessages;
    private AdminView view;
    private AppDAOs appDAOs;
    private boolean isRunning;

    public AdminController(AdminView view, AppDAOs appDAOs) {
        this.view = view;
        this.appDAOs = appDAOs;
        isRunning = true;
        errorMessages = new ErrorMessages();
    }

    @Override
    public void run() {
        while (isRunning){
            handleMenu();
        }
    }

    private void handleMenu(){
        String userChoice;

        view.printMenu(ADMIN_OPTIONS);
        try{
            userChoice = view.getInput();
        } catch (NoSuchElementException e){
            view.printError(errorMessages.getEMPTY_INPUT_MESSAGE());
            return;
        }

        switch (userChoice){
            case "1":
                handleCreatingAccount();
                break;
            case "2":
                isRunning = false;
                break;
            default:
                view.printError(errorMessages.getNO_OPTION_MESSAGE());
                break;
        }


    }

    private void handleCreatingAccount(){
        Account account = view.getAccountInformation();
        appDAOs.getDAOAccounts().insertAccount(account);
        account = appDAOs.getDAOAccounts().getAccountByNicknameAndPassword(account.getNickname(), account.getPassword());
        int user_id = account.getId();
        
        switch (account.getAccessLevel()){
            case MENTOR:
                handleCreatingMentor(user_id);
                break;
            case CODECOOLER:
                // TO DO
                break;
        }
    }

    private void handleCreatingMentor(int user_id){
        boolean areMentorInformationsValid = false;

        while (! areMentorInformationsValid){
            Mentor mentor = view.getMentorInformation();
            // Save Mentor to DB
            // If Mentor can be saved successfully, exit loop
            // Delete below statement:
            areMentorInformationsValid = true;
        }
    }
}
