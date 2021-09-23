package com.ecommerce.productservice.query.mapper;

import com.ecommerce.productservice.entity.Product;
import com.ecommerce.productservice.model.ProductRestModel;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = false))
public interface ProductRestMapper {

    @Mappings({
            @Mapping(source = "product.productId", target = "productId"),
            @Mapping(source = "product.productName", target = "productName"),
            @Mapping(source = "product.price", target = "price"),
            @Mapping(source = "product.quantity", target = "quantity")
    })
    ProductRestModel productToProductRestModel(Product product);

    @Mappings({})
    List<ProductRestModel> productToProductRestModel(List<Product> product);
}
