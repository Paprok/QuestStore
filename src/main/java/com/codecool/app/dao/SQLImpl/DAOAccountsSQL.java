package com.codecool.app.dao.SQLImpl;

import com.codecool.app.connectors.SQLConnector;
import com.codecool.app.dao.DAOAccounts;
import com.codecool.app.login.Account;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOAccountsSQL implements DAOAccounts {
    private Connection sqlConnection;

    public DAOAccountsSQL() {
        this.sqlConnection = SQLConnector.getConnection();
    }

    public Account getAccount(String nick, String password) {
        String getAccountSQL = createStatement(nick, password);
        Statement statement = null;
        try {
            statement = this.sqlConnection.createStatement();
            statement.execute("");
        } catch (SQLException e){
            System.out.println("Invalid statement creation");
        }

        return null;
    }

    private String createStatement(String nick, String password){
        StringBuilder statement = new StringBuilder();
        return statement.toString();
    }
}
