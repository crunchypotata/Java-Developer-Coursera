package com.coffeshop.menu.service;

import com.coffeshop.menu.model.Product;
import com.coffeshop.menu.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProductById(int id) {
        //TODO 3: JpaRepositories findById() method returns an Optional Object of type Product
        Optional<Product> optional = productRepository.findById(id);
        //TODO 4: declare a null product object.
        Product product = null;
        //TODO 5: use the if-else block to see if any product record is returned or not
        if (optional.isPresent() ) {
            //TODO 6: if the product is returned then assign to product object.
            product = optional.get();
        }else{
            //TODO 7: else throw a Runtime Exception with a relevant message of record not found with that id.
            throw new RuntimeException("Product not found for id :: " + id);
        }
        return product;
    }

    @Override
    public void deleteProductById(int id) {
        //TODO 8: call the deleteById() method of ProductRepository
        productRepository.deleteById(id);
    }
}
