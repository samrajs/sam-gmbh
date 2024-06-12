package com.sam.payment.domain.event;

import java.time.ZonedDateTime;

import com.sam.common.event.DomainEvent;
import com.sam.payment.domain.entity.CompletedPayment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaymentCompleted implements DomainEvent<CompletedPayment> {
    private final CompletedPayment payment;
    private final ZonedDateTime createAt;

}
