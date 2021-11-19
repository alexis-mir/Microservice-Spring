package com.alexismiranda.product.service;

import com.alexismiranda.product.entity.Category;
import com.alexismiranda.product.entity.Product;

import java.util.List;

/**
 * @author Alexis
 */
public interface ProductService {
    List<Product> listAllProducts();
    Product findById(Long id);
    Product create(Product product);
    Product update(Product product);
    Product delete(Long id);
    List<Product> findByCategory(Category category);
    Product addStock(Long id, Double quantity);
}
