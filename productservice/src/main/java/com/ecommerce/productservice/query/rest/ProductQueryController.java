package com.ecommerce.productservice.query.rest;

import com.ecommerce.productservice.model.ProductRestModel;
import com.ecommerce.productservice.queries.FindProductsQuery;
import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
@AllArgsConstructor
public class ProductQueryController {

    private QueryGateway queryGateway;

    @GetMapping()
    public List<ProductRestModel> prodGet() {
        FindProductsQuery findProductsQuery = new FindProductsQuery();
        List<ProductRestModel> productRestModels= queryGateway.query(findProductsQuery, ResponseTypes.multipleInstancesOf(ProductRestModel.class)).join();
        return productRestModels;
    }

}
