package com.codecool.app.dao;

import com.codecool.app.connectors.SQLConnector;
import com.codecool.app.login.Account;

import java.sql.Connection;

public class DAOAccountsSQL implements  DAOAccounts {
    private Connection sqlConnection;

    public DAOAccountsSQL() {
        this.sqlConnection = SQLConnector.getConnection();
    }

    public Account getAccount(String nick, String password) {

        return null;
    }
}
