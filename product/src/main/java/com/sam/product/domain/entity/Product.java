package com.sam.product.domain.entity;

import java.util.Optional;
import java.util.UUID;

import com.sam.common.entity.AggregateRoot;
import com.sam.product.domain.exception.InvalidProductCategory;
import com.sam.product.domain.exception.ProductTooCostly;
import com.sam.product.domain.exception.WrongProductStatus;
import com.sam.product.domain.valueobject.Money;
import com.sam.product.domain.valueobject.ProductCategory;
import com.sam.product.domain.valueobject.ProductId;
import com.sam.product.domain.valueobject.ProductStatus;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Product extends AggregateRoot<ProductId> {
    private String name;
    private String description;
    private Money price;
    private ProductCategory category;
    private ProductStatus status;

    public void init() {
        setId( new ProductId( UUID.randomUUID() ) );
    }

    public void validate() {
        if ( price.isGreaterThan( Money.of(10000L) ) ) {
            throw new ProductTooCostly( name, price.getAmount() );
        }

        if ( category == ProductCategory.HOME_APPLIANCES ) {
            throw new InvalidProductCategory( category );
        }
    }

    public void makeItAvailable() {
        if ( status != ProductStatus.PENDING ) {
            throw new WrongProductStatus( status, ProductStatus.AVAILABLE );
        }
    }

    public void phaseItOut() {
        if ( status != ProductStatus.AVAILABLE ) {
            throw new WrongProductStatus( status, ProductStatus.PHASING_OUT );
        }
    }
}
