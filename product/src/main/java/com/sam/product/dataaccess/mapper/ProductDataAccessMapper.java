package com.sam.product.dataaccess.mapper;

import org.springframework.stereotype.Component;

import com.sam.product.dataaccess.entity.ProductEntity;
import com.sam.product.domain.entity.Product;
import com.sam.product.domain.valueobject.Money;
import com.sam.product.domain.valueobject.ProductId;

@Component
public class ProductDataAccessMapper {
    public ProductEntity productToProductEntity( Product product ) {
        return ProductEntity.builder()
                    .id( product.getId().getValue() )
                    .name( product.getName() )
                    .description( product.getDescription() )
                    .price( product.getPrice().getAmount())
                    .status( product.getStatus() )
                    .category( product.getCategory() )
                    .build();
    }

    public Product productEntityToProduct( ProductEntity productEntity ) {
        return Product.builder()
                    .id( new ProductId( productEntity.getId() ) )
                    .name( productEntity.getName())
                    .description( productEntity.getDescription() )
                    .price( new Money( productEntity.getPrice() ) )
                    .status( productEntity.getStatus() )
                    .category( productEntity.getCategory() )
                    .build();
    }
}
