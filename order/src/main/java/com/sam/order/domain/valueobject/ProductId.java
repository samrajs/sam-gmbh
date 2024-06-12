package com.sam.order.domain.valueobject;

import java.util.UUID;

import com.sam.common.valueobject.BaseId;

public class ProductId extends BaseId<UUID> {
    public ProductId(UUID value) {
        super(value);
    }

    public static ProductId from( UUID uuid ) {
        return new ProductId( uuid );
    }
}