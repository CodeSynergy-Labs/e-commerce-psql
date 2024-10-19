package com.example.cartify.service;

import com.example.cartify.dao.ProductDao;
import com.example.cartify.dto.request.ProductRequestDto;
import com.example.cartify.dto.response.ProductResponseDto;

import java.util.List;

public interface ProductService {
    List<ProductResponseDto> getAllProducts();
    ProductResponseDto getProductById(Long id);
    ProductResponseDto addProduct(ProductRequestDto productRequestDto);
    ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto);
    void deleteProduct(Long id);
}
