package com.alexismiranda.product;

import com.alexismiranda.product.entity.Category;
import com.alexismiranda.product.entity.Product;
import com.alexismiranda.product.repository.ProductRepository;
import com.alexismiranda.product.service.ProductService;
import com.alexismiranda.product.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Alexis
 */
@SpringBootTest
class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private final ProductService productService = new ProductServiceImpl();

    static final private Category categoryMock01 = Category.builder()
            .id(1L)
            .name("Category1")
            .build();
    static final private Category categoryMock02 = Category.builder()
            .id(2L)
            .name("Category2")
            .build();
    static final private Product productMock01 = Product.builder()
            .id(1L)
            .name("product1")
            .description("description1")
            .stock(Double.parseDouble("440"))
            .price(Double.parseDouble("1290.99"))
            .status("CREATED")
            .createAt(LocalDateTime.now())
            .category(categoryMock01)
            .build();
    static final private Product productDeletedMock01 = Product.builder()
            .id(productMock01.getId())
            .name(productMock01.getName())
            .description(productMock01.getDescription())
            .stock(productMock01.getStock())
            .price(productMock01.getPrice())
            .status("DELETED")
            .createAt(productMock01.getCreateAt())
            .category(productMock01.getCategory())
            .build();
    static final private Product productMock02 = Product.builder()
            .id(2L)
            .name("product2")
            .description("description2")
            .stock(Double.parseDouble("399"))
            .price(Double.parseDouble("390.99"))
            .status("CREATED")
            .createAt(LocalDateTime.now())
            .category(categoryMock01)
            .build();
    static final private Product productMock03 = Product.builder()
            .id(2L)
            .name("product3")
            .description("description3")
            .stock(Double.parseDouble("299"))
            .price(Double.parseDouble("320.99"))
            .status("DELETED")
            .createAt(LocalDateTime.now())
            .category(categoryMock01)
            .build();
    static final private Product productUpdateMock01 = Product.builder()
            .id(productMock01.getId())
            .name("productUPDATE")
            .description("descriptionUPDATE")
            .stock(productMock01.getStock())
            .price(Double.parseDouble("99990.99"))
            .status("CREATED")
            .createAt(productMock01.getCreateAt())
            .category(categoryMock01)
            .build();
    static final Long idNullCase = 999L;

//        when(productRepository.findById(1L)).thenReturn(Optional.of(productMock01));
//        when(productRepository.findById(2L)).thenReturn(Optional.of(productMock02));
//        when(productRepository.findAll()).thenReturn(List.of(productMock01,productMock02,productMock03));
//        when(productRepository.save(productUpdateMock)).thenReturn(productUpdateMock);
//        when(productRepository.findByCategory(categoryMock01)).thenReturn(List.of(productMock01,productMock02,productMock03));
//        when(productRepository.findByCategory(categoryMock02)).thenReturn(List.of());
//        when(productRepository.save(productMock01)).thenReturn(productDeletedMock01);

    @Test
    void find_by_id_01() {
        when(productRepository.findById(productMock01.getId())).thenReturn(Optional.of(productMock01));
        Product product = productService.findById(productMock01.getId());
        assertEquals(productMock01, product);
    }

    @Test
    void find_by_id_02() {
        when(productRepository.findById(productMock02.getId())).thenReturn(Optional.of(productMock02));
        Product product = productService.findById(productMock02.getId());
        assertEquals(productMock02, product);
    }

    @Test
    void find_by_id_null_case() {
        when(productRepository.findById(idNullCase)).thenReturn(Optional.empty());
        Product product = productService.findById(idNullCase);
        assertNull(product);
    }

    @Test
    void find_all() {
        List<Product> productListMock = List.of(ProductServiceTest.productMock01, productMock02, productMock03);
        when(productRepository.findAll()).thenReturn(productListMock);
        List<Product> products = productService.listAllProducts();
        assertEquals(productListMock, products);
    }

    @Test
    void find_all_empty_DB() {
        when(productRepository.findAll()).thenReturn(List.of());
        List<Product> products = productService.listAllProducts();
        assertEquals(0, products.size());
    }
}
