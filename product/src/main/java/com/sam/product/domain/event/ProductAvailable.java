package com.sam.product.domain.event;

import java.time.ZonedDateTime;

import com.sam.common.event.DomainEvent;
import com.sam.product.domain.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductAvailable implements DomainEvent<Product> {
    private final Product product;
    private final ZonedDateTime createAt;

}
