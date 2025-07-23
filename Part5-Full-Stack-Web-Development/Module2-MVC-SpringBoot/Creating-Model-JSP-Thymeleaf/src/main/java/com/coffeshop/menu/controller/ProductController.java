package com.coffeshop.menu.controller;

import com.coffeshop.menu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.coffeshop.menu.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/") // This maps to the URL http://localhost:8080/
    public String viewHomePage(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "menu"; // This will return the index.html page
    }

    @GetMapping("/showNewProductForm")
    public String showNewProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "add-new-product"; // This will return the new_product.html page
    }

   @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/"; // Redirect to the home page after saving
    }

    @GetMapping("/showFormForUpdate/{id}")
    //TODO 11: Use @PathVariable in method argument to id from thyme leaf tag
    public String showFormForUpdate(@PathVariable int id, Model model) {
    //TODO 12: get product from the service
        Product product = productService.getProductById(id);
    //TODO 13: set product as a model attribute to pre-populate the form
        model.addAttribute("product", product);
        return "update-product";
    }
    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProductById(id);
        return "redirect:/"; // Redirect to the home page after deletion
    }
}
