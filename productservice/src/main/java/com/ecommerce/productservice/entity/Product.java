package com.ecommerce.productservice.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
public class Product implements Serializable {

    @Id
    @Column(unique = true)
    private String productId;
    @Column(unique = true)
    private String productName;
    private BigDecimal price;
    private Long quantity;

}
