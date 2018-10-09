package com.codecool.app;

public class Account {
    private String nickname;
    private String password;
    private AccessLevel accessLevel;

    public Account(String nickname, String password){
        this.nickname = nickname;
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    public AccessLevel getAccessLevel(){
        return accessLevel;
    }

    public boolean comparePassword(String input){
        return password.equals(input);
    }
}
