package com.sam.order.domain.valueobject;

import com.sam.common.valueobject.BaseId;

public class OrderItemId extends BaseId<Long> {
    public OrderItemId(Long value) {
        super(value);
    }

    public static OrderItemId from( Long value ) {
        return new OrderItemId(value);
    }
}