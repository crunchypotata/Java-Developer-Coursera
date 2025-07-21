package com.coffeshop.menu.service;
import com.coffeshop.menu.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    void saveProduct(Product product);
}
