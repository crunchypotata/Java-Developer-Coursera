package com.example;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDAO {
    private static final String url = "jdbc:mysql://localhost:3306/clicknbuy";
    private static final String user_Name = "root";
    private static final String password = "password";

    public static int addUser(User newUser) throws ClassNotFoundException, SQLException { 
        Connection clickNBuyConnection = DatabaseUtility.getDbConnection(url, user_Name,password);
        String sqlQuery = "INSERT INTO clicknbuy.user (username, user_email, first_name, last_name, phone_number, reward_points) VALUES (?,?,?,?,?,?)";

        PreparedStatement insertPreparedStatement = clickNBuyConnection.prepareStatement(sqlQuery);
        insertPreparedStatement.setString(1, newUser.getUserName());
        insertPreparedStatement.setString(2, newUser.getUserEmail());
        insertPreparedStatement.setString(3, newUser.getFirstName());
        insertPreparedStatement.setString(4, newUser.getLastName());
        insertPreparedStatement.setString(5, newUser.getPhoneNumber());
        insertPreparedStatement.setInt(6, newUser.getRewardPoints());
        int rowsUpdated = insertPreparedStatement.executeUpdate();
        return rowsUpdated;

    }
}
