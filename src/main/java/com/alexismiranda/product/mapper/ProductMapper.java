package com.alexismiranda.product.mapper;

import com.alexismiranda.product.dto.ProductRequestDTO;
import com.alexismiranda.product.dto.ProductResponseDTO;
import com.alexismiranda.product.entity.Product;
import org.mapstruct.Mapper;

/**
 * @author Alexis
 */
@Mapper
public interface ProductMapper {
    ProductResponseDTO toResponseDTO (Product product);
    Product toEntity (ProductRequestDTO requestDTO);
}
