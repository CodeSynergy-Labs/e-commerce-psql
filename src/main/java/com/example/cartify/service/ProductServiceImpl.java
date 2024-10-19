package com.example.cartify.service;

import com.example.cartify.dao.ProductDao;
import com.example.cartify.dto.request.ProductRequestDto;
import com.example.cartify.dto.response.ProductResponseDto;
import com.example.cartify.error.ProductNotFoundException;
import com.example.cartify.mapper.ProductRequestMapper;
import com.example.cartify.mapper.ProductResponseMapper;
import com.example.cartify.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);


    private final ProductRepository productRepository;

    private final ProductRequestMapper productRequestMapper;

    private final ProductResponseMapper productResponseMapper;

    @Override
    public List<ProductResponseDto> getAllProducts() {
        productRepository.findAll();
        return null;
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        logger.debug("Fetching product with id: {}", id);
        final ProductDao productDao = productRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Product with id {} not found", id);
                    return new ProductNotFoundException("Product not found");
                });

        return productResponseMapper.mapDaoToResponseDto(productDao);
    }

    @Override
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) {
        if (productRepository.existsByName(productRequestDto.getName())) {
            throw new ProductNotFoundException("Product with name " + productRequestDto.getName() + " already exists");
        }
        final ProductDao productDao = productRequestMapper.mapRequestDtoToDao(productRequestDto);
        productRepository.save(productDao);
        return productResponseMapper.mapDaoToResponseDto(productDao);
    }

    @Override
    public ProductResponseDto updateProduct(final Long id, final ProductRequestDto productRequestDto) {
        productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found"));

        final ProductDao updatedProductDao = ProductDao.builder().name(productRequestDto.getName()).
                description(productRequestDto.getDescription()).price(productRequestDto.getPrice())
                .quantity(productRequestDto.getQuantity())
                .build();

        productRepository.save(updatedProductDao);
        return productResponseMapper.mapDaoToResponseDto(updatedProductDao);
    }

    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }
        productRepository.deleteById(id);
    }
}

