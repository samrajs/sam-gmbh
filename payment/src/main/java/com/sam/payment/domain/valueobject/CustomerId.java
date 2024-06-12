package com.sam.payment.domain.valueobject;

import java.util.UUID;

import com.sam.common.valueobject.BaseId;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString(callSuper = true)
public class CustomerId extends BaseId<UUID> {
    public CustomerId(UUID value) {
        super(value);
    }

    public static CustomerId from( UUID value ) {
        return new CustomerId(value);
    }
}