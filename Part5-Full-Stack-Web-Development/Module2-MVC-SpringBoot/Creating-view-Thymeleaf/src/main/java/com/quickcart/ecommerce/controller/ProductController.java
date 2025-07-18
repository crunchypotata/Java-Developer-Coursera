package com.quickcart.ecommerce.controller;

import com.quickcart.ecommerce.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @GetMapping({"/", "/products"})
    public String getProducts(Model productModel) {

        List<Product> products = new ArrayList<>();

        Product laptop = new Product(1, "Laptop", "A laptop for work and play", 500.0);
        Product smartphone = new Product(2, "Smartphone", "A smartphone for communication", 300.0);
        Product headphones = new Product(3, "Headphones", "A pair of headphones for music", 50.0);

        products.add(laptop);
        products.add(smartphone);
        products.add(headphones);

        productModel.addAttribute("products", products);

        return "products";
    }

}
