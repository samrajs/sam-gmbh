package com.sam.payment.domain.valueobject;

import java.util.UUID;

import com.sam.common.valueobject.BaseId;

import lombok.ToString;

@ToString(callSuper = true)
public class PaymentId extends BaseId<UUID> {
    public PaymentId(UUID value) {
        super(value);
    }

    public static PaymentId from( UUID value ) {
        return new PaymentId(value);
    }
}