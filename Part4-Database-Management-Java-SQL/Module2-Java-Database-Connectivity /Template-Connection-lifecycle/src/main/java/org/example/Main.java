package org.example;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        // source
        MysqlDataSource mysqlDatabase = new MysqlDataSource();
        mysqlDatabase.setURL("jdbc:mysql://localhost:3306/database");
        mysqlDatabase.setUser("root");
        mysqlDatabase.setPassword("password");

        // Prepared Statement
        String sqlQuery = "SELECT * FROM users WHERE username = ?";

        try (Connection mysqlDatabaseConnection = mysqlDatabase.getConnection();
            PreparedStatement preparedSQLStatement = mysqlDatabaseConnection.prepareStatement(sqlQuery)) {
            preparedSQLStatement.setString(1, "john_doe");

            try (ResultSet queryResultSet = preparedSQLStatement.executeQuery()) {
                while (queryResultSet.next()) {
                    System.out.println("User ID: " + queryResultSet.getInt("id"));
                    System.out.println("Username: " + queryResultSet.getString("username"));
                }
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}