package com.alexismiranda.product.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Alexis
 */
@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer stock;
    private Float price;
    private String status;
    private LocalDateTime createAt;
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

}
