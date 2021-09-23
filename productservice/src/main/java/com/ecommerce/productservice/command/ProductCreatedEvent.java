package com.ecommerce.productservice.command;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductCreatedEvent {

    private String productId;
    private String productName;
    private BigDecimal price;
    private Long quantity;

}
