package com.codecool.app.messages;

public class LoginMessages {
    private final String ASK_FOR_NICKNAME = "Please enter nickname";
    private final String ASK_FOR_PASSWORD = "Please enter password";
    private final String USER_NOT_LOGGED_MESSAGE = "No user is logged in";
    private final String USER_NOT_REGISTERED_MESSAGE = "Entered nickname and passwords doesn\'t matches";

    public String getASK_FOR_NICKNAME(){
        return ASK_FOR_NICKNAME;
    }

    public String getASK_FOR_PASSWORD(){
        return ASK_FOR_PASSWORD;
    }

    public String getUSER_NOT_LOGGED_MESSAGE() {
        return USER_NOT_LOGGED_MESSAGE;
    }

    public String getUSER_NOT_REGISTERED_MESSAGE() {
        return USER_NOT_REGISTERED_MESSAGE;
    }
}
