package com.codecool.app.view.consoleimpl;

import com.codecool.app.login.Account;
import com.codecool.app.login.LoginMessages;
import com.codecool.app.view.LoginView;

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
