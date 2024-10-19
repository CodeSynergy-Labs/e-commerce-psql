package com.example.cartify;

import com.example.cartify.dao.ProductDao;
import com.example.cartify.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CartifyIntegrationTest extends AbstractPostgreSQLContainerTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testCreateProduct() {
        // Create a new ProductDao object
        ProductDao product = ProductDao.builder()
                .name("Test Product")
                .description("Test Description")
                .price(100.0)
                .quantity(10)
                .build();

        // Save the product to the database
        ProductDao savedProduct = productRepository.save(product);

        // Assert that the product was saved correctly
        assertNotNull(savedProduct.getId());
        assertEquals("Test Product", savedProduct.getName());
    }

    @Test
    public void testReadProduct() {
        // Create and save a product
        ProductDao product = ProductDao.builder()
                .name("Test Product")
                .description("Test Description")
                .price(100.0)
                .quantity(10)
                .build();
        ProductDao savedProduct = productRepository.save(product);

        // Retrieve the product by ID
        ProductDao retrievedProduct = productRepository.findById(savedProduct.getId()).orElse(null);

        // Assert that the retrieved product matches the saved product
        assertNotNull(retrievedProduct);
        assertEquals(savedProduct.getId(), retrievedProduct.getId());
    }

    @Test
    public void testUpdateProduct() {
        // Create and save a product
        ProductDao product = ProductDao.builder()
                .name("Test Product")
                .description("Test Description")
                .price(100.0)
                .quantity(10)
                .build();
        ProductDao savedProduct = productRepository.save(product);


        // Update the product details
        savedProduct.setName("Updated Product");
        savedProduct.setPrice(120.0);
        ProductDao updatedProduct = productRepository.save(savedProduct);

        // Assert that the product was updated correctly
        assertEquals("Updated Product", updatedProduct.getName());
        assertEquals(120.0, updatedProduct.getPrice());
    }

    @Test
    public void testDeleteProduct() {
        // Create and save a product
        ProductDao product = ProductDao.builder()
                .name("Test Product")
                .description("Test Description")
                .price(100.0)
                .quantity(10)
                .build();
        ProductDao savedProduct = productRepository.save(product);

        // Delete the product
        productRepository.deleteById(savedProduct.getId());

        // Assert that the product was deleted
        assertFalse(productRepository.findById(savedProduct.getId()).isPresent());
    }
}

