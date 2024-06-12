package com.sam.payment.domain.valueobject;

import java.util.UUID;

import com.sam.common.valueobject.BaseId;

import lombok.ToString;

@ToString(callSuper = true)
public class OrderId extends BaseId<UUID> {
    public OrderId(UUID value) {
        super(value);
    }

    public static OrderId from( UUID value ) {
        return new OrderId(value);
    }
}