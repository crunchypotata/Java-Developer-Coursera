package com.lesson.lab;

import java.lang.reflect.Array;

public class TextEditorUndo {
    private String[] stack;
    private int top;

    // Constructor to initialize the stack and top index
    public TextEditorUndo(int size) {
        // TODO 1: initialize the stack array
        stack = new String[size];
        // TODO 2: set initial top index to -1
        top = -1;
    }

    // Method to add a new action to the stack
    public void push(String action) {
        // TODO 3: check if the stack is full
        if (top == stack.length - 1) {
            // TODO 4: print message if the stack is full
            System.out.println("Stack is full");
        } else {
            // TODO 5: increment top and add action to the stack
            // TODO 6: print confirmation message
            stack [++top] = action;
            System.out.println("Element " + action + "has added");
        }
    }
    // Method to remove and return the most recent action from the stack
    public String pop() {
        // TODO 7: Check if the stack is empty
        if (top == -1) {
            // TODO 8: Print message if the stack is empty and return null
            System.out.println("Stack is empty");
            return null;
        } else {
            // TODO 9: Retrieve and remove the top action from the stack
            String action = stack [top--];
            // TODO 10: Print confirmation message, return and replace empty string with the undone action
            System.out.println("Removed :"+ action);
            return action;
        }


    }
    // Method to view the most recent action in the stack without removing it
    public String peek() {
        // TODO 11: Check if the stack is empty

        if (top == -1) {
            // TODO 12: Print message if the stack is empty and return null
            System.out.println("Stack is empty! No elements to peek.");
            return null;
        } else {
            // TODO 13: Return and replace empty string with the most recent action without removing it

            System.out.println("Top element: " + stack[top]);
            return stack[top];
        }

    }

    // Method to display all actions in the stack
    public void display() {
        // TODO 14: Check if the stack is empty

        if (top == -1) {
            // TODO 15: Print message if the stack is empty

            System.out.println("Stack is empty!");
        } else {
            // TODO 16: Iterate through the stack and print each action
            // TODO 17: Print a new line after displaying all actions

            for (int i = 0; i <= top; i++) {
                System.out.println(stack[i]);
            }
        }


    }
}