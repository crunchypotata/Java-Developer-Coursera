package com.example.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Customer;

public class DatabaseUtils {

    private ConnectionHelper mysqlDatabaseConnectionHelper;

    public DatabaseUtils(String databaseURL, String username, String password) {
        // create an instance of the ConnectionHelper class
        this.mysqlDatabaseConnectionHelper = new ConnectionHelper();
        // connect to the MySQL database using the provided databaseURL, username, and password
        this.mysqlDatabaseConnectionHelper.connect(databaseURL, username, password);
    }

    public List<Customer> getAllCustomers() {

        // create a list to store customer objects that will be fetched from the database
        List<Customer> customers = new ArrayList<Customer>();

        try (
            // TODO 6: fetch the connection instance created in the constructor by calling the getConnection() method and call the getConnection() method on it
            Connection mysqlDatabaseConnection = mysqlDatabaseConnectionHelper.getDataSource().getConnection();
            // TODO 7: create a statement instance to execute queries on the MySQL database
            Statement sqlStatement = mysqlDatabaseConnection.createStatement();
            // TODO 8: execute a query to fetch customer data from the coffee_orders table
            ResultSet fetchAllCustomersQueryResultSet = sqlStatement.executeQuery("SELECT * FROM coffee_orders;");
        ) {

           // while the result set has more rows
           while (fetchAllCustomersQueryResultSet.next()) {

            // TODO 9: fetch the value of each column from the coffee_orders table one by one
            long orderID = fetchAllCustomersQueryResultSet.getLong("order_id");
            String customerName = fetchAllCustomersQueryResultSet.getString("customer_name");

            int quantity = fetchAllCustomersQueryResultSet.getInt("quantity");

            double totalPrice = fetchAllCustomersQueryResultSet.getDouble("total_price");
            // TODO 10: put all the fetched values into a Java object of the Customer class
            Customer customer = new Customer(orderID, customerName, quantity, totalPrice);
            // TODO 11: put this customer object in the list
            customers.add(customer);
        }

        } catch (SQLException exception) {
            // print an error message on the console
            System.err.println("Error fetching customers from the database");
            System.err.println(exception.getMessage());
            exception.printStackTrace();
        }
        
        // return the list of customers fetched from the database
        return customers;
    }
}
