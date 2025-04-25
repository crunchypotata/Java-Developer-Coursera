package com.lesson.lab;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        TextEditorUndo undoStack = new TextEditorUndo(10); // Maximum 10 actions
        while (true) {
            System.out.println("\nText Editor Undo Mechanism");
            System.out.println("1. Add Edit Action");
            System.out.println("2. Undo Last Edit");
            System.out.println("3. View Last Edit");
            System.out.println("4. Display All Actions");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice;
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
                    System.out.print("Enter edit action: ");
                    String action = keyboard.nextLine();
                    undoStack.push(action);
                    break;
                case 2:
                    undoStack.pop();
                    break;
                case 3:
                    String lastAction = undoStack.peek();
                    if (lastAction != null) {
                        System.out.println("Last edit action: \"" + lastAction + "\"");
                    }
                    break;
                case 4:
                    undoStack.display();
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
