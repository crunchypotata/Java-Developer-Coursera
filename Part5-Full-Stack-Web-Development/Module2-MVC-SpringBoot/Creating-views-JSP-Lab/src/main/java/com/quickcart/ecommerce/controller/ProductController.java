package com.quickcart.ecommerce.controller;

import org.springframework.stereotype.Controller;
import com.quickcart.ecommerce.model.Product;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController{

    @GetMapping({"/", "/products"})
    public String getProducts(Model productModel) {
        List<Product> products = new ArrayList<>();

        Product laptop = new Product(1, "Laptop", "Mac 2025", 1598.60);
        Product smartphone = new Product(2, "Smartphone", "IPhone", 1287.99);
        Product headphone = new Product(3, "Headphones", "AirPods", 600.50);

        products.add(laptop);
        products.add(smartphone);
        products.add(headphone);

        productModel.addAttribute("products", products);
        return "products";
    }
}
