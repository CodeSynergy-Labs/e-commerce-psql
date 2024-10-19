package com.example.cartify.mapper;

import com.example.cartify.dao.ProductDao;
import com.example.cartify.dto.request.ProductRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ProductMapperMapper {
    @Mapping(target = "id", ignore = true) // Ignore the id field in ProductDao
    ProductDao sourceToDestination(ProductRequestDto productRequestDto);
    ProductRequestDto destinationToSource(ProductDao productDao);
}