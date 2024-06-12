package com.sam.product.domain.event;

import java.time.ZonedDateTime;

import com.sam.common.event.DomainEvent;
import com.sam.product.domain.entity.Product;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ProductPhasingOut implements DomainEvent<Product> {
    private final Product product;
    private final ZonedDateTime createdAt;
}
