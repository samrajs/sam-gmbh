package com.sam.payment.domain.valueobject;

import java.util.UUID;

import com.sam.common.valueobject.BaseId;

import lombok.ToString;

@ToString(callSuper = true)
public class CreditHistoryId extends BaseId<UUID> {
    public CreditHistoryId(UUID value) {
        super(value);
    }

    public static CreditHistoryId from( UUID value ) {
        return new CreditHistoryId(value);
    }
}