package com.example;

import java.util.List;
import java.util.Scanner;

import com.example.database.DatabaseUtils;
import com.example.model.Customer;

public class Main {
    public static void main(String[] args) {
        
        // create a connection to the database
        DatabaseUtils databaseUtility  = new DatabaseUtils("jdbc:mysql://localhost:3306/clicknbuy", "root", "password");

        System.out.println("Connected to the 'clicknbuy' database successfully!");

        // show a menu to the user 
        System.out.println("--- Java For Devs Coffee Place ---");
        System.out.println("1. Press 1 to view all customers.");

        // fetch some keyboard input
        Scanner keyboard = new Scanner(System.in);

        int choice = keyboard.nextInt();

        keyboard.close();

        if (choice == 1) {
            // fetch all customers from the database and store them in a list
            List<Customer> allCustomers = databaseUtility.getAllCustomers();

            // print all the customers
            for (Customer customer : allCustomers) {
                System.out.println(customer);
            }

        } else {
            System.out.println("Please enter a valid choice");
        }
    }
}