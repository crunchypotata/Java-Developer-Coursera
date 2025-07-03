package org.example;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Enumeration<Driver> drivers = DriverManager.getDrivers();
            while(drivers.hasMoreElements()) {
                System.out.println(drivers.nextElement().getClass().getName());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Drivers not found");
        }

    }
}

