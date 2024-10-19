package com.example.cartify.service;

import com.example.cartify.dto.request.ProductRequestDto;
import com.example.cartify.dto.response.ProductResponseDto;
import com.example.cartify.error.ProductNotFoundException;
import com.example.cartify.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);


    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductResponseDto> getAllProducts() {
        // productRepository.findAll();
        return null;
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
      /*  logger.debug("Fetching product with id: {}", id);
        return productRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Product with id {} not found", id);
                    return new ProductNotFoundException("Product not found");
                });*/
        return null;
    }

    @Override
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) {
     /*   if (productRepository.existsByName(productRequestDto.getName())) {
            throw new ProductNotFoundException("Product with name " + productRequestDto.getName() + " already exists");
        }
        return productRepository.save(productDao);*/
        return null;
    }

    @Override
    public ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto) {
        // Fetch the existing product
      /*  productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found"));


        updatedProductDao = ProductDao.builder().name(updatedProductDao.getName()).
                description(updatedProductDao.getDescription()).price(updatedProductDao.getPrice())
                .quantity(updatedProductDao.getQuantity()).categoryDao(updatedProductDao.getCategoryDao())
                .build();


        final ProductDao productDao = productRepository.save(updatedProductDao);*/

        return null;

    }

    @Override
    public void deleteProduct(Long id) {
        // Check if the product exists before attempting to delete
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }
        productRepository.deleteById(id);
    }
}

