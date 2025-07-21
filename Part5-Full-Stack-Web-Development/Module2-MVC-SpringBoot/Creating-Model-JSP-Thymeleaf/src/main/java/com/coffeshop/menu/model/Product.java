package com.coffeshop.menu.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name= "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @NotNull
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotNull(message="Product price is required")
    @Min(value = 1, message = "Product price must be a positive value")
    private double price;

    public Product() {
//        this.id = id;
//        this.name = name;
//        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product ID: " +
                id +
                ", Name: " + name +
                ", Price: " + price + "$";
    }
}
