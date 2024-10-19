package com.example.cartify.dto.request;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;


@Builder
@Getter
public class CategoryRequestDto {
    private UUID categoryId;
    private String name;
}
