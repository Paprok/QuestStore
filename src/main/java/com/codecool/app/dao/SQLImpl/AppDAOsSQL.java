package com.codecool.app.dao.SQLImpl;

import com.codecool.app.dao.DAOAccounts;
import com.codecool.app.dao.AppDAOs;

public class AppDAOsSQL implements AppDAOs {
    @Override
    public DAOAccounts getDAOAccounts() {
        return new DAOAccountsSQL();
    }
}
