package com.example.shoppinglist.service;

import com.example.shoppinglist.model.Product;
import com.example.shoppinglist.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get a product by ID
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // Add a new product
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // Update an existing product
    public Product updateProduct(Long id, Product productDetails) {
        Product updatingProduct = productRepository.findById(id).orElse(null);
        if (updatingProduct != null) {

            updatingProduct.setProductName(productDetails.getProductName());
            updatingProduct.setPrice(productDetails.getPrice());
            updatingProduct.setDescription(productDetails.getDescription());
            return productRepository.save(updatingProduct);
        }
        return null;
    }

    // Delete a product by ID
    public String deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return "Product deleted with id " + id;
        } else {
            return "Product not found with id " + id;
        }
    }
}
