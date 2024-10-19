package com.example.cartify.controller;

import com.example.cartify.dto.request.ProductRequestDto;
import com.example.cartify.dto.response.ProductResponseDto;
import com.example.cartify.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        List<ProductResponseDto> productResponseDtos = productService.getAllProducts();
        return ResponseEntity.ok().body(productResponseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long id) {
        final ProductResponseDto productResponseDto = productService.getProductById(id);
        return ResponseEntity.ok().body(productResponseDto);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> addProduct(@RequestBody @Validated ProductRequestDto productRequestDto) {
        final ProductResponseDto productResponseDto = productService.addProduct(productRequestDto);
        return ResponseEntity.ok().body(productResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable Long id, @RequestBody @Validated ProductRequestDto productRequestDto) {
        final ProductResponseDto productResponseDto = productService.updateProduct(id, productRequestDto);
        return ResponseEntity.ok().body(productResponseDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}

