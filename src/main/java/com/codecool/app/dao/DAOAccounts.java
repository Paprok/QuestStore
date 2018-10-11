package com.codecool.app.dao;

import com.codecool.app.login.Account;

public interface DAOAccounts {
    Account getAccountByNicknameAndPassword(String nickname, String password);
    void insertAccount(Account account);
    void updateAccount(int id, Account newAccount);
    void deleteAccount(int id);
}
