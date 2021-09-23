package com.ecommerce.productservice.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductDto {

    private String productId;
    private String productName;
    private BigDecimal price;
    private Long quantity;

}
