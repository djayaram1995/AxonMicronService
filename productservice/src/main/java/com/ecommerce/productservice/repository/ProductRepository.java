package com.ecommerce.productservice.repository;

import com.ecommerce.productservice.entity.Product;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

public interface ProductRepository extends JpaRepository<Product, String> {
    Product findProductByProductId(String id);
    Product findProductByProductIdOrProductName(String id, String productName);

}
