package com.codecool.app.login;

public class Account {
    private int id;
    private String nickname;
    private String password;
    private AccessLevel accessLevel;

    public Account(String nickname, String password){
        this.nickname = nickname;
        this.password = password;
        accessLevel = AccessLevel.NOBODY;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    public AccessLevel getAccessLevel(){
        return accessLevel;
    }
}
