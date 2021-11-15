package com.alexismiranda.product.repository;

import com.alexismiranda.product.entity.Category;
import com.alexismiranda.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Alexis
 */
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByCategory(Category category);
}
