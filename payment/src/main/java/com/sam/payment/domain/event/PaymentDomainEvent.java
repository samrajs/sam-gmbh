package com.sam.payment.domain.event;

import com.sam.common.event.DomainEvent;
import com.sam.payment.domain.entity.Payment;

public interface PaymentDomainEvent extends DomainEvent<Payment> {
    Payment getPayment();    
}
