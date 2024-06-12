package com.sam.payment.domain.valueobject;

import java.util.UUID;

import com.sam.common.valueobject.BaseId;

import lombok.ToString;

@ToString(callSuper = true)
public class ProductId extends BaseId<UUID> {
    public ProductId(UUID value) {
        super(value);
    }
}