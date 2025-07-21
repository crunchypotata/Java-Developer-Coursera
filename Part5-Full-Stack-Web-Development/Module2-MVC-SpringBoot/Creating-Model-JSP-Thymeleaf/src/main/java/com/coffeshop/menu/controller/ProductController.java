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


//@Controller
//@RequestMapping("/products")
//public class ProductController {
//    private List<Product> productsList = List.of(
//            new Product(1, "Espresso", 2.50),
//            new Product(2, "Latte", 3.50),
//            new Product(3, "Croissant", 2.00),
//            new Product(4, "Chocolate Muffin", 2.25),
//            new Product(5, "Americano", 2.75)
//    );
//
//    @RequestMapping("/") // This maps to the URL http://localhost:8080/products/
//    @ResponseBody
//    public String home() {
//        return "Welcome to the Coffee Shop!";
//    }


//    @RequestMapping("/list")
//    public String listProducts(Model productListModel) {
//        productListModel.addAttribute("products", productsList);
//        return "menu"; // path /WEB-INF/jsp/menu.jsp
//    }
//
//    @RequestMapping("/details/{id}") // This maps to the URL http://localhost:8080/products/details/{id}
//    @ResponseBody
//    public String getProductDetailsByID(@PathVariable int id){
//        for (Product product : productsList) {
//            if (product.getId() == id) {
//                return "<strong>Requested Product Details: </strong> <hr> Product ID: " + product.getId() + "<br> Name: " + product.getName() + "<br> Price: $" + product.getPrice();
//            }
//        }
//        return "Product not found!";
//    }
}
