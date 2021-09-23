package com.ecommerce.productservice.query;

import com.ecommerce.productservice.command.ProductCreatedEvent;
import com.ecommerce.productservice.entity.Product;
import com.ecommerce.productservice.model.ProductRestModel;
import com.ecommerce.productservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ProductQueryHandler {

    private ProductRepository productRepository;
    //private ProductRestMapper productRestMapper;

    @EventHandler
    public List<ProductRestModel> findProducts(ProductCreatedEvent productCreatedEvent) {

        //return productRestMapper.map(productRepository.findAll());
        return null;
    }
}
