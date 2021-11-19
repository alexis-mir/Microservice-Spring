package com.alexismiranda.product.dto;

import com.alexismiranda.product.entity.Category;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Alexis
 */
@Data
public class ProductResponseDTO {
    private Long id;
    private String name;
    private String description;
    private Double stock;
    private Double price;
    private String status;
    private LocalDateTime createAt;
    private Category category;
}
