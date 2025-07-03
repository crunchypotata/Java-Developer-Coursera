package com.example.database;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnectionHelper {

    // an instance to the MysqlDataSource is already created, you only need to initialize its properties to connect to the MySQL database
    private MysqlDataSource mysqlDatabase;

    public MysqlDataSource getDataSource() {
        return this.mysqlDatabase;
    }

    // complete the connect() method to connect to the MySQL database
    public void connect(String databaseURL, String username, String password) {
        // TODO 2: initialize the mysqlDatbase field using the MySQLDataSource class's no-args constructor
        mysqlDatabase = new MysqlDataSource();
        
        // TODO 3: set the URL for the MySQL database by calling the setURL() method on the mysqlDatabase field
        mysqlDatabase.setUrl("jdbc:mysql://localhost:3306/clicknbuy");

        // TODO 4: set the username for database authentication by calling the setUser() method on the mysqlDatabase field
        mysqlDatabase.setUser("root");

        // TODO 5: set the password for database authentication by calling the setPassword() method on the mysqlDatabase field
        // The password should be 'password'
        mysqlDatabase.setPassword("password");

    }
}
