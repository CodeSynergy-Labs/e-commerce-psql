package com.example.cartify.dto.response;

import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class ProductResponseDto {

    private UUID id;
    private String name;

    private String description;

    private double price;

    private int quantity;

}
