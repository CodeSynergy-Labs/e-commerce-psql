package com.example.cartify.mapper;

import com.example.cartify.dao.ProductDao;
import com.example.cartify.dto.request.ProductRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductRequestMapper {
    public ProductDao mapRequestDtoToDao(final ProductRequestDto productRequestDto) {
        return ProductDao.builder().name(productRequestDto.getName()).
                price(productRequestDto.getPrice()).
                quantity(productRequestDto.getQuantity())
                .description(productRequestDto.getDescription()).build();
    }
}
