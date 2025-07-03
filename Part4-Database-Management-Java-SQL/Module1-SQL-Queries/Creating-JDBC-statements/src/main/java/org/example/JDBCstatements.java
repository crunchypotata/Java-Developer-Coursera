package org.example;

import java.sql.*;

public class JDBCstatements {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Chinook";
        String user = "";
        String password = "";


        // Example genre to search for
        String genre = "Rock";


        try {
            // Establish a connection to the database
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database successfully!");

            // TODO Prepare the SQL statement with a parameterized query
            String query = "SELECT Name FROM track WHERE GenreId = (SELECT GenreId FROM genre WHERE Name = ?)";


            PreparedStatement pstmt = conn.prepareStatement(query);

            // Set the genre parameter in the prepared statement
            pstmt.setString(1, genre);

            // Execute the query to get track names
            ResultSet rs = pstmt.executeQuery();

            // Iterate through the ResultSet and print each track name
            while (rs.next()) {
                String trackName = rs.getString("Name"); // Retrieve track name
                System.out.println("Track: " + trackName); // Print track name
            }

            // Close the ResultSet and PreparedStatement after use
            rs.close();
            pstmt.close();
            // Close the database connection
            conn.close();
        } catch (SQLException e) {
            // Handle any SQL exceptions that occur
            e.printStackTrace();
        }
    }
}
