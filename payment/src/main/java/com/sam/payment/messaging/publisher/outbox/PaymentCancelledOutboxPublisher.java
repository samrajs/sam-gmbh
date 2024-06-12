package com.sam.payment.messaging.publisher.outbox;

import org.springframework.stereotype.Component;

import com.sam.payment.application.ports.output.message.publisher.PaymentCancelledMessagePublisher;
import com.sam.payment.domain.event.PaymentCancelled;
import com.sam.payment.messaging.entity.OutboxEntity;
import com.sam.payment.messaging.mapping.PaymentResponseDataMapper;
import com.sam.payment.messaging.repository.OutboxRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentCancelledOutboxPublisher implements PaymentCancelledMessagePublisher {
    private final PaymentResponseDataMapper mapper;
    private final OutboxRepository repository;
    
    @Override
    public void publish(PaymentCancelled domainEvent) {
        String orderId = domainEvent.getPayment().getOrderId().getValue().toString();

        log.info( "Payment cancelled for the order : {}", orderId );

        OutboxEntity outbox = mapper.toOutbox(domainEvent);

        repository.save(outbox);
    }
}
