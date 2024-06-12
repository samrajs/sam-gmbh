package com.sam.order.messaging.publisher.outbox;

import org.springframework.stereotype.Component;

import com.sam.order.application.ports.output.message.publisher.OrderCancelledEventPublisher;
import com.sam.order.domain.event.OrderCancelled;
import com.sam.order.messaging.entity.OutboxEntity;
import com.sam.order.messaging.mapper.OrderCancelledDataMapper;
import com.sam.order.messaging.repository.OutboxRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class OrderCancelledEventOutboxPublisher implements OrderCancelledEventPublisher {
    private final OrderCancelledDataMapper mapper;
    private final OutboxRepository repository;

    @Override
    public void publish(OrderCancelled event) {
        String orderId = event.getOrder().getId().getValue().toString();
        log.info( "OrderCreated event to be published for {}", orderId );
        OutboxEntity outbox = mapper.toOutboxEntity(event);

        repository.save(outbox);
    }

}
