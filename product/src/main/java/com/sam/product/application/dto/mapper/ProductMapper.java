package com.sam.product.application.dto.mapper;

import org.springframework.stereotype.Component;

import com.sam.product.application.dto.create.CreateProductCommand;
import com.sam.product.application.dto.create.CreateProductResponse;
import com.sam.product.domain.entity.Product;
import com.sam.product.domain.valueobject.Money;

@Component
public class ProductMapper {
    public Product createProductCommandToProduct( CreateProductCommand command ) {
        return Product.builder()
            .name( command.getName() )
            .description( command.getDescription() )
            .price( new Money( command.getPrice() ) )
            .category( command.getCategory() )
            .status( command.getStatus() )
            .build();
    }

    public CreateProductResponse productToCreateProductResponse( Product product ) {
        return CreateProductResponse.builder().productId( product.getId().getValue() ).build();
    }
}
