package com.ecommerce.productservice.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
public class CreateProductDto {

    @NotBlank(message = "Can not be empty")
    private String productName;
    @Min(value = 1, message = "Can't be lesser than 1")
    private BigDecimal price;
    @Min(value = 1, message = "Can't be lesser than 1")
    @Max(value = 5, message = "Can't be greater than 5")
    private Long quantity;

}
