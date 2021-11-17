package com.alexismiranda.product.service.impl;

import com.alexismiranda.product.entity.Category;
import com.alexismiranda.product.entity.Product;
import com.alexismiranda.product.repository.ProductRepository;
import com.alexismiranda.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Alexis
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product create(Product product) {
        product.setStatus("CREATED");
        product.setCreateAt(LocalDateTime.now());
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product, Long id) {
        Product productDB = findById(id);
        if (productDB == null) return null;
        productDB.setName(product.getName());
        productDB.setDescription(product.getDescription());
        productDB.setCategory(product.getCategory());
        productDB.setPrice(product.getPrice());
        productDB.setStock(product.getStock());
        return productRepository.save(productDB);
    }

    @Override
    public Product delete(Long id) {
        Product product = findById(id);
        if (product == null) return null;
        product.setStatus("DELETED");
        return productRepository.save(product);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public Product addStock(Long id, Double quantity) {
        Product product = findById(id);
        if (product == null) return null;
        product.setStock(product.getStock()+quantity);
        return productRepository.save(product);
    }
}
