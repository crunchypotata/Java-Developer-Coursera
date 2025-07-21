package com.coffeshop.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.coffeshop.menu.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // This interface will automatically provide CRUD operations for Product entities
    // No additional methods are needed unless custom queries are required
}
