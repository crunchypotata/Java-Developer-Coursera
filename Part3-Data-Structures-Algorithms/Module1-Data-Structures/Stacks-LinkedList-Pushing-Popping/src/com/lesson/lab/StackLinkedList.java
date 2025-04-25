package com.lesson.lab;

// StackLinkedList class to implement stack operations
public class StackLinkedList {
    // Node class to represent each element in the stack
    class Node {
        String data; // Data stored in the node (e.g., an action or text)
        Node next;   // Reference to the next node

        public Node(String data) {
            this.data = data;
            this.next = null; // Initialize the next node as null
        }
    }

    private Node top; // Top of the stack

    // Constructor to initialize the stack
    public StackLinkedList() {
        // TODO 1: set the top variable to null in the constructor to indicate an empty stack
        this.top = null;
    }
    // Push Operation - Add elements to the stack
    public void push(String action) {
        // TODO 2: create a new Node object with the action
        Node newNode = new Node(action);
        // TODO 3: set the next of new node to current top
        newNode.next = top;
        // TODO 4: update the top to new node
        top = newNode;
        // TODO 5: print a confirmation message
        System.out.println("Element has added at the top");
    }

    //Pop Operation - Remove and return the top element of the stack
    public String pop() {
        // TODO 6: check if the stack is empty
        if (top == null) {
            // TODO 7: print message if the stack is empty and return null
            System.out.println("Stack is empty");
            return null;
        } else {
            // TODO 8: store the data of the top node
            String poppedValue = top.data;
            // TODO 9: update the top pointer to the next node
            top = top.next;
            // TODO 10: print a confirmation message and return the removed data
            System.out.println("Removed data :" + poppedValue);
            return poppedValue;
        }
    }

    // Peek Operation - Display the top element without removing it
    public String peek() {
        // TODO 11: check if the stack is empty
        if (top == null) {
            // TODO 12: print message if the stack is empty and return null
            System.out.println("Stack is empty! No elements to peek.");
            return null;
        } else {
            // TODO 13: retrieve the data from the top node
            // TODO 14: print the top element data
            System.out.println("Top element: " + top.data);
            // TODO 15: return the data from the top node
            return top.data;
        }
    }

    // Display All Elements - List all elements in the stack
    public void display() {
        // TODO 16: check if the stack is empty by verifying if top is null.
        if (top == null) {
            // TODO 17: if the stack is empty, print a message and return.
            System.out.println("Stack is empty!");
            return;
        } else {
            // TODO 18: initialize the current node to top.
            System.out.println("Stack element");
            Node current = top;
            // TODO 19: traverse the stack using a while loop.
            while (current != null) {
                // TODO 20: print the data of the current node during each iteration.
                System.out.println("Element: " + current.data);
                current = current.next;
            }
            // TODO 21: update current to current.next to move to the next node.
        }
    }
}
