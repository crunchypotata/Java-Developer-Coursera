package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static void main(String[] args) {
        // Connection details for the Chinook MySQL database
        String url = "jdbc:mysql://localhost:3306/TestDatabase";
        String user = ""; // Replace with your MySQL username
        String password = ""; // Replace with your MySQL password
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Check if the connection was successful
            if (connection != null) {
                System.out.println("Connected to the TestDatabase database!");
            }
        } catch (SQLException e) {
            // Handle SQL errors during connection
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}