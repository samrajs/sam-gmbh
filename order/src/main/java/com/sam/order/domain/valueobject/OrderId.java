package com.sam.order.domain.valueobject;

import java.util.UUID;

import com.sam.common.valueobject.BaseId;

public class OrderId extends BaseId<UUID> {
    public OrderId(UUID value) {
        super(value);
    }

    public static OrderId from(UUID id) {
        return new OrderId(id);
    }
}