package com.ecommerce.productservice.query;

import com.ecommerce.productservice.command.ProductCreatedEvent;
import com.ecommerce.productservice.entity.Product;
import com.ecommerce.productservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductEventsHandler {

    private ProductRepository productRepository;

    @EventHandler
    public void on(ProductCreatedEvent productCreatedEvent) {
      Product product=new Product();
      BeanUtils.copyProperties(productCreatedEvent, product);
      productRepository.save(product);
    }
}
