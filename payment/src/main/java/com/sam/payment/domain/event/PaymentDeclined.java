package com.sam.payment.domain.event;

import java.time.ZonedDateTime;

import com.sam.common.event.DomainEvent;
import com.sam.payment.domain.entity.DeclinedPayment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaymentDeclined implements DomainEvent<DeclinedPayment> {
    private final DeclinedPayment payment;
    private final ZonedDateTime createAt;
}
