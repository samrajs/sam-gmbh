package com.sam.payment.application.ports.output.message.publisher;

import com.sam.common.event.DomainEventPublisher;
import com.sam.payment.domain.event.PaymentCancelled;

public interface PaymentCancelledMessagePublisher extends DomainEventPublisher<PaymentCancelled>{

}
