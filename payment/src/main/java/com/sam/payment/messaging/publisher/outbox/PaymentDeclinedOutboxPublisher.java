package com.sam.payment.messaging.publisher.outbox;

import org.springframework.stereotype.Component;

import com.sam.payment.application.ports.output.message.publisher.PaymentDeclinedMessagePublisher;
import com.sam.payment.domain.event.PaymentDeclined;
import com.sam.payment.messaging.entity.OutboxEntity;
import com.sam.payment.messaging.mapping.PaymentResponseDataMapper;
import com.sam.payment.messaging.repository.OutboxRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentDeclinedOutboxPublisher implements PaymentDeclinedMessagePublisher {
    private final PaymentResponseDataMapper mapper;
    private final OutboxRepository repository;
    
    @Override
    public void publish(PaymentDeclined event) {
        String orderId = event.getPayment().getOrderId().getValue().toString();

        log.info( "Payment declined for the order : {}", orderId );

        OutboxEntity outbox = mapper.toOutbox(event);

        repository.save(outbox);
    }
}
