package com.lab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BankingSystem {
    public static void initializeDatabase() {
        try (Connection conn = getDatabaseConnection()) {
            if (conn != null) {
                createTables(conn);  
                resetDatabase(conn); 
                System.out.println("Database initialized: tables created and reset.");
            }
        } catch (SQLException e) {
            System.err.println("Initialization error: " + e.getMessage());
        }
    }

    public static void resetDatabase(Connection conn) {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("DELETE FROM accounts");
            stmt.executeUpdate("DELETE FROM customers");
            stmt.executeUpdate("ALTER TABLE accounts AUTO_INCREMENT = 1");
            stmt.executeUpdate("ALTER TABLE customers AUTO_INCREMENT = 1");
        } catch (SQLException e) {
            System.err.println("Reset failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Connection conn = null;
        try {
            initializeDatabase();
            // establish the connection to MySQL
            conn = getDatabaseConnection();
            // check connection is not null before using it
            if (conn != null) {
                // Start a transaction
                conn.setAutoCommit(false);
                // BankingSystem.createDatabase(conn);
                BankingSystem.createTables(conn);

                Customer customer1 = new Customer(0, "John Doe", "123 Main St");
                BankingSystem.createCustomerAccount(conn, customer1, 500.00);
                Customer customer2 = new Customer(0, "Jane Smith", "456 Oak St");
                BankingSystem.createCustomerAccount(conn, customer2, 1000.00);

                customer1.setAddress("456 New Address");
                BankingSystem.updateCustomerDetails(conn, customer1);

                BankingSystem.viewAllCustomers(conn);
                BankingSystem.deleteCustomerAccount(conn, 1);
            }
        } catch (SQLException e) {
            System.err.println("Main SQLException :" + e.getMessage());
        } finally {
            // close the connection if it was successfully opened
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                    System.out.println("Auto-commit restored and connection closed.");
                } catch (SQLException e) {
                    System.err.println("Error closing the database connection: " + e.getMessage());
                }
            }
        }
    }

    // Task 1: Create a new customer and their account
    public static void createCustomerAccount(Connection conn, Customer customer, double initialBalance) {
        String customerInsertSQL = "INSERT INTO customers (name, address) VALUES (?, ?)";
        String accountInsertSQL = "INSERT INTO accounts (customer_id, balance) VALUES (?, ?)";

        try {
            // Insert new customer into customers table
            try (PreparedStatement customerStmt = conn.prepareStatement(customerInsertSQL, PreparedStatement.RETURN_GENERATED_KEYS)) {
                // TODO 1: insert the customer into the customers table
                // Get generated customer ID

                customerStmt.setString(1, customer.getName());
                customerStmt.setString(2, customer.getAddress());
                int affectedRows = customerStmt.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Creating customer failed, no rows affected.");
                }

                try (ResultSet generatedKeys = customerStmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int customerId = generatedKeys.getInt(1);
                        customer.setId(customerId);  // Set the generated ID to the customer object
                    
                        try (PreparedStatement insertAccount = conn.prepareStatement(accountInsertSQL)) {
                            // TODO 2:insert new account into accounts table
                
                            insertAccount.setInt(1, customerId);
                            insertAccount.setDouble(2, initialBalance);
                            insertAccount.executeUpdate();
                        }
                        // Commit the transaction
                        conn.commit();
                        // Confirm the successful creation of the customer and account
                        System.out.println("Account created for " + customer.getName() + " successfully.");
                    } else {
                        throw new SQLException("Creating customer failed, no ID obtained.");
                    }
                }
            }
        } catch (SQLException e) {
            // TODO 3: if any error occurs, rollback the transaction
            try {
                 // Roll back the transaction if an error occurs
                conn.rollback();
                System.out.println("Transaction rolled back due to error: " + e.getMessage());
            } catch (SQLException rollbackEx) {
                System.out.println("Rollback failed: " + rollbackEx.getMessage());
            }
        }
    }


    // Task 2: Update customer details
    public static void updateCustomerDetails(Connection conn, Customer customer) {
        // TODO 4: write the SQL UPDATE query to change the customer's address in the customers table
        String updateSQL = "UPDATE customers SET address = ? WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(updateSQL)) {

            // TODO 5: use the customer's ID to locate the customer record in the database
            /* TODO 6: run the SQL update using executeUpdate()
             * save the result in a variable called rowsAffected.
             * display message if the customer's details were successfully updated.
             *  If at least one row is affected, show a success message "customer name details updated successfully."
             *   Otherwise, let them know the "customer wasn't found".
             */
            stmt.setString(1, customer.getAddress());
            stmt.setInt(2, customer.getId());
            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println(customer.getName() + " details updated successfully.");
            } else {
                System.out.println("Customer wasn't found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Task 3: Delete a customer account
    public static void deleteCustomerAccount(Connection conn, int accountId) {
        // TODO 7: Write SQL DELETE queries to remove the account from the accounts table and, optionally, the customer from the customers table

        String deleteAccountSQL = "DELETE FROM accounts WHERE id = ?";
        String deleteCustomerSQL = "DELETE FROM customers WHERE id = ?";

        try {
            //Got customer_id by accountId
            int customerId = getCustomerIdFromAccountId(conn, accountId);
            // TODO 8: retrieve the customer ID associated with this account
            // TODO 9: delete the account
            // TODO 10: if the customer has no other accounts, delete the customer from the customers table
            
            if (customerId == -1) {
                System.out.println("Account not found, nothing to delete.");
                return;
            }
            //deleting account
            try (PreparedStatement deleteAccountStmt = conn.prepareStatement(deleteAccountSQL)) {
                deleteAccountStmt.setInt(1, accountId);
                deleteAccountStmt.executeUpdate();
            }
            //Cheacking other accounts, using hasOtherAccounts method
            boolean hasOtherAccounts = hasOtherAccounts(conn, customerId);
            if (!hasOtherAccounts) {
                try (PreparedStatement deleteCustomerStmt = conn.prepareStatement(deleteCustomerSQL)) {
                    deleteCustomerStmt.setInt(1, customerId);
                    deleteCustomerStmt.executeUpdate();
                }
                System.out.println("Customer ID " + customerId + " deleted as they had no other accounts.");
            } else {
                System.out.println("Customer ID " + customerId + " has other accounts, not deleted.");
            }

            // Commit the transaction
            conn.commit();
            System.out.println("Bank account belong to " + customerId + " deleted successfully.");
        } catch (SQLException e) {
            System.err.println("SQLException :" + e.getMessage());
        }
    }

    // Task 4: View all customers and their account details
    public static void viewAllCustomers(Connection conn) {
        // TODO 11: write an SQL SELECT query to fetch customer names, addresses, account IDs, and balances by joining the customers and accounts tables
  
        String query = "SELECT customers.name, customers.address, accounts.id AS account_id, accounts.balance " +
               "FROM customers LEFT JOIN accounts ON customers.id = accounts.customer_id";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            /* TODO 12: loop through the ResultSet to display all customer and account details 
             * fetch customer name
             * fetch customer address
             * fetch customer account id
             * fetch customer balance
             * display details in this format "Customer: %s, Address: %s, Account: %d, Balance: %.2f"
            */
            while (rs.next()) {
                String name = rs.getString("name");
                String address = rs.getString("address");
            
                int accountId = rs.getInt("account_id");
                boolean noAccount = rs.wasNull(); // check if accountId was null
            
                double balance = rs.getDouble("balance");
                if (rs.wasNull()) balance = 0.0;
            
                if (noAccount) {
                    System.out.printf("Customer: %s, Address: %s, No account found%n", name, address);
                } else {
                    System.out.printf("Customer: %s, Address: %s, Account: %d, Balance: %.2f%n",
                            name, address, accountId, balance);
                }
            }


        } catch (SQLException e) {
            System.err.println("SQLException :" + e.getMessage());
        }
    }

    // Helper method to get customer ID from account ID
    private static int getCustomerIdFromAccountId(Connection conn, int accountId) throws SQLException {
        String query = "SELECT customer_id FROM accounts WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, accountId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("customer_id");
            }
        }
        return -1;
    }

    // Helper method to check if the customer has other accounts
    private static boolean hasOtherAccounts(Connection conn, int customerId) throws SQLException {
        String query = "SELECT COUNT(*) FROM accounts WHERE customer_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }

    public static void createDatabase(Connection conn) throws SQLException {
        String query = "CREATE DATABASE IF NOT EXISTS BankDB";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
            System.out.println("Database 'BankDB' created (if not exists).");
        }
    }

    // Method to create the Inventory Management database
    public static void createTables(Connection conn) {
        try (Statement stmt = conn.createStatement()) {
            String createCustomersTableSQL = "CREATE TABLE IF NOT EXISTS customers (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(255), " +
                    "address VARCHAR(255))";
    
            String createAccountsTableSQL = "CREATE TABLE IF NOT EXISTS accounts (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "customer_id INT, " +
                    "balance DOUBLE, " +
                    "FOREIGN KEY (customer_id) REFERENCES customers(id) ON DELETE CASCADE)";
    
            stmt.executeUpdate(createCustomersTableSQL);
            stmt.executeUpdate(createAccountsTableSQL);
    
            System.out.println("Tables created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating tables: " + e.getMessage());
        }
    }
    
    
    public static Connection getDatabaseConnection() {
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "BankDB";
        String fullUrl = url + dbName + "?useSSL=false&serverTimezone=UTC";
        String user = "";
        String password = "";
    
        try {
            
            try (Connection tempConn = DriverManager.getConnection(url, user, password)) {
                createDatabase(tempConn);
            }

            Connection conn = DriverManager.getConnection(fullUrl, user, password);
            createTables(conn);
    
            return conn;
        } catch (SQLException e) {
            System.out.println("Connection failed SQLException: " + e.getMessage());
            return null;
        }
    }
}
