package com.ecommerce.productservice.query.rest;

import com.ecommerce.productservice.command.CreateProductCommand;
import com.ecommerce.productservice.model.CreateProductDto;
import com.ecommerce.productservice.model.ProductRestModel;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("products")
@AllArgsConstructor
public class ProductQueryController {
    private Environment environment;
    private CommandGateway commandGateway;

    @GetMapping()
    public List<ProductRestModel> prodGet() {
        return null;
    }

}
