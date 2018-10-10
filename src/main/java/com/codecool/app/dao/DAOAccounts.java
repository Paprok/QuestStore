package com.codecool.app.dao;

import com.codecool.app.login.Account;

public interface DAOAccounts {
    Account getAccount(String nick, String password);
}
