package com.ecommerce.productservice.query;

import com.ecommerce.productservice.command.ProductCreatedEvent;
import com.ecommerce.productservice.model.ProductRestModel;
import com.ecommerce.productservice.queries.FindProductsQuery;
import com.ecommerce.productservice.query.mapper.ProductRestMapper;
import com.ecommerce.productservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ProductQueryHandler {

    private ProductRepository productRepository;
    private ProductRestMapper productRestMapper;

    @QueryHandler
    public List<ProductRestModel> findProducts(FindProductsQuery findProductsQuery) {

        return productRestMapper.productToProductRestModel(productRepository.findAll());

    }
}
