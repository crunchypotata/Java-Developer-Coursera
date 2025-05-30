package com.example.model;

// This Java class models the MySQL database table that contains customer data. 
// The fields in this Java class correspond to the database table.

public class Customer {
    private long id;
    private String name;
    private int quantity;
    private double totalPrice;

    public Customer(long id, String name, int quantity, double totalPrice) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String toString() {
        return "id: " + this.getId() + " name: " + this.getName() + " quantity: " + this.getQuantity() + " total price: " + this.getTotalPrice();
    }
}
