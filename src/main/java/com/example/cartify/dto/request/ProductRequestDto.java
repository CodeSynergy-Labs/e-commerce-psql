package com.example.cartify.dto.request;

import com.example.cartify.constants.Constant;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ProductRequestDto {

    @NotBlank(message = Constant.PRODUCT_NAME_REQUIRED)
    private String name;

    @NotBlank(message = Constant.PRODUCT_DESCRIPTION_REQUIRED)
    private String description;

    @Min(value = 0, message = Constant.PRICE_REQUIRED)
    private double price;

    @Min(value = 0, message = Constant.QUANTITY_REQUIRED)
    private int quantity;

}
