package com.example.cartify.mapper;


import com.example.cartify.dao.ProductDao;
import com.example.cartify.dto.request.ProductRequestDto;
import com.example.cartify.dto.response.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductResponseMapper {

    public ProductResponseDto mapDaoToResponseDto(final ProductDao productDao) {
        return ProductResponseDto.builder().name(productDao.getName()).
                price(productDao.getPrice()).
                quantity(productDao.getQuantity())
                .description(productDao.getDescription()).build();
    }
}
