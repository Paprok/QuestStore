package com.codecool.app.connectors;

import java.sql.*;

public class SQLConnector {
    private static Connection connection = null;

    private static void createConnection() throws SQLException {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ferned", "ferned", "qwepoi69");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM applicants;");
        System.out.println("Opened database successfully");
        resultSet.next();
        System.out.println(resultSet.getString(2));
    }

    public static Connection getConnection(){
        if(connection == null){
            try {
                createConnection();
            } catch (SQLException e) {
                System.out.println("Couldn't createConnection to database");
            }
        } return connection;
    }
}
