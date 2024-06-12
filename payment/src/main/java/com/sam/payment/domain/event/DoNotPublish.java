package com.sam.payment.domain.event;

import java.time.ZonedDateTime;

import com.sam.payment.domain.entity.CancelledPayment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DoNotPublish implements PaymentDomainEvent {
    private final CancelledPayment payment;
    private final ZonedDateTime createAt;
}
