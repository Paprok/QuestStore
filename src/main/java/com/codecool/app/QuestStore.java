package com.codecool.app;

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
            }
        }
    }

    private void logIn(){
        LoginController loginController = new LoginController(new LoginViewConsoleImp());

    }
}
