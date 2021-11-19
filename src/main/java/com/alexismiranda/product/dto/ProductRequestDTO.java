package com.alexismiranda.product.dto;

import com.alexismiranda.product.entity.Category;
import lombok.Data;

/**
 * @author Alexis
 */
@Data
public class ProductRequestDTO {
    private Long id;
    private String name;
    private String description;
    private Double stock;
    private Double price;
    private String status;
    private Category category;
}
