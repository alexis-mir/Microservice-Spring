package com.alexismiranda.product.controller;

import com.alexismiranda.product.dto.ProductResponseDTO;
import com.alexismiranda.product.mapper.ProductMapper;
import com.alexismiranda.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alexis
 */
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    public ResponseEntity<List<ProductResponseDTO>> listProducts(){
        List<ProductResponseDTO> products = productService.listAllProducts().stream()
                .map(productMapper::toResponseDTO)
                .collect(Collectors.toList());
        if (products.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(products);
    }
}
