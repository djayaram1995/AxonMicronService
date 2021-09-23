package com.ecommerce.productservice.command.rest;

import com.ecommerce.productservice.command.CreateProductCommand;
import com.ecommerce.productservice.model.CreateProductDto;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("products")
@AllArgsConstructor
public class ProductCommandsController {

    private CommandGateway commandGateway;

    @PostMapping()
    public String prodPost(@RequestBody CreateProductDto createProductDto) {
        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .productId(UUID.randomUUID().toString())
                .productName(createProductDto.getProductName())
                .price(createProductDto.getPrice())
                .quantity(createProductDto.getQuantity())
                .build();
        String output = "";
        try {
            output = commandGateway.sendAndWait(createProductCommand);
        } catch (Exception e) {
            output = e.getLocalizedMessage();
        }

        return output;
    }
}
