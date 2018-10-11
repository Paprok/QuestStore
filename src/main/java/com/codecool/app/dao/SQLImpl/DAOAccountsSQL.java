package com.codecool.app.dao.SQLImpl;

import com.codecool.app.connectors.SQLConnector;
import com.codecool.app.dao.DAOAccounts;
import com.codecool.app.login.AccessLevel;
import com.codecool.app.login.Account;

import java.sql.*;
import java.util.NoSuchElementException;

public class DAOAccountsSQL implements DAOAccounts {
    private Connection connection;

    public DAOAccountsSQL() {
        this.connection = SQLConnector.getConnection();
    }

    @Override
    public Account getAccountByNicknameAndPassword(String nickname, String password) {
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM accounts WHERE nick=? AND password=?");
            ps.setString(1, nickname);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()){
                return extractAccountFromResultSet(resultSet);
            }

            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }

        throw new NoSuchElementException();
    }

    @Override
    public void insertAccount(Account account) {
        String sql = "INSERT INTO accounts (user_id, nick, type, password) VALUES (?, ?, ?, ?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, account.getId());
            ps.setString(2, account.getNickname());
            ps.setString(3, account.getAccessLevel().toString());
            ps.setString(4, account.getPassword());
            ps.executeQuery();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateAccount(int id, Account newAccount) {
        String sql = "UPDATE accounts SET user_id=?, nick=?, type=?, password=? WHERE user_id=?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, newAccount.getId());
            ps.setString(2, newAccount.getNickname());
            ps.setString(3, newAccount.getAccessLevel().toString());
            ps.setString(4, newAccount.getPassword());
            ps.setInt(5, id);
            ps.executeQuery();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAccount(int id) {
        try{
            Statement stmt = connection.createStatement();
            stmt.executeQuery("DELETE FROM accounts WHERE id=" + id);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private Account extractAccountFromResultSet(ResultSet resultSet) throws SQLException{
        Account account = new Account(resultSet.getString("nick"), resultSet.getString("password"));
        account.setAccessLevel(AccessLevel.getAccessLevel(resultSet.getString("type")));
        account.setId(resultSet.getInt("user_id"));

        return account;
    }
}
