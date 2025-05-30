package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtility {
    public static Connection getDbConnection(String url, String userName, String password) throws ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection clickNBuyConnection = DriverManager.getConnection(url, userName, password);
        return clickNBuyConnection;
    }
}
