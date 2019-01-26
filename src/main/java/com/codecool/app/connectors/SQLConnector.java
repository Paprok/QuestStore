package com.codecool.app.connectors;

import java.sql.*;

public class SQLConnector {
    private static Connection connection = null;

    public static Connection getConnection(){
        if(connection == null){
            try {
                createConnection();
            } catch (SQLException e) {
                System.out.println("Couldn't create connection to database");
            }
        } return connection;
    }

    private static void createConnection() throws SQLException {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/queststore", "queststore", "admin123");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}
