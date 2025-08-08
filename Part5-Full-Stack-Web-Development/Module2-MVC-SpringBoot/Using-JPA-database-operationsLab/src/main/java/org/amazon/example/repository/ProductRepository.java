package org.amazon.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.amazon.example.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // This interface will automatically provide CRUD operations for Product entities
    // No additional methods are needed unless custom queries are required
}
