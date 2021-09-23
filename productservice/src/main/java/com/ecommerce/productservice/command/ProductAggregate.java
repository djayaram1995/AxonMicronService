package com.ecommerce.productservice.command;

import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
@NoArgsConstructor
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private String productName;
    private BigDecimal price;
    private Long quantity;

    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand) {
        if (createProductCommand.getPrice().equals(BigDecimal.ZERO)) {
            throw new IllegalArgumentException("Price no zero");
        }
        if (createProductCommand.getProductName().isEmpty()) {
            throw new IllegalArgumentException("Product name not be empty");
        }
        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();
        BeanUtils.copyProperties(createProductCommand, productCreatedEvent);
        AggregateLifecycle.apply(productCreatedEvent);
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent productCreatedEvent) {
        this.productId = productCreatedEvent.getProductId();
        this.productName = productCreatedEvent.getProductName();
        this.price = productCreatedEvent.getPrice();
        this.quantity = productCreatedEvent.getQuantity();
    }
}
