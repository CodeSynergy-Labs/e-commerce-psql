package com.example.cartify.dto.request;

import com.example.cartify.constants.Constant;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductRequestDto {


    @NotBlank(message = Constant.PRODUCT_NAME_REQUIRED)
    private String name;

    @NotBlank(message = Constant.PRODUCT_DESCRIPTION_REQUIRED)
    private String description;

    @Min(value = 0, message = Constant.VALID_PRICE_REQUIRED)
    private double price;

    @Min(value = 0, message = Constant.VALID_QUANTITY_REQUIRED)
    private int quantity;

}
