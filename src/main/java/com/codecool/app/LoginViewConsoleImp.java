package com.codecool.app;

public class LoginViewConsoleImp extends ViewConsoleImp implements LoginView {
    LoginMessages loginMessages;

    public LoginViewConsoleImp(){
        loginMessages = new LoginMessages();
    }

    @Override
    public Account getAccount() {
        String nickname, password;

        println(loginMessages.getASK_FOR_NICKNAME());
        nickname = getInput();
        println(loginMessages.getASK_FOR_PASSWORD());
        password = getInput();

        return new Account(nickname, password);
    }
}
