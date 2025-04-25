package com.lesson.lab;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();
        Scanner keyboard = new Scanner(System.in);
        String action;
        int choice;

        while (true) {
            System.out.println("\nStack Operations:");
            System.out.println("1. Add elements ");
            System.out.println("2. Remove top element ");
            System.out.println("3. Display the top element");
            System.out.println("4. Display all elements");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = -1;
            try {
                choice = keyboard.nextInt();
                keyboard.nextLine(); // Consume newline character
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                keyboard.nextLine(); // Clear invalid input
                continue; // Skip the rest of the loop iteration
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter the action to push: ");
                    action = keyboard.nextLine();
                    stack.push(action);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.peek();
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    keyboard.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
