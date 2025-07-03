package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
        /**TODO 12: Declare URL, USER and PASSWORD variables. 
         Define a static method getConnection() that returns MySQL Connection object.**/
         private static final String URL = "jdbc:mysql://localhost:3306/mynewdatabase"; 
         private static final String USER = "root"; // Your MySQL username
         private static final String PASSWORD = "password"; // Your MySQL password
     

    @SuppressWarnings("exports")
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
}
