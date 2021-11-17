package com.alexismiranda.product.entity;

import lombok.*;


import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Alexis
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double stock;
    private Double price;
    private String status;
    private LocalDateTime createAt;
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

}
