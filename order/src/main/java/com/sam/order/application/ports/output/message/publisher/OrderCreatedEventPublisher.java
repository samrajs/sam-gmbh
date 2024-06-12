package com.sam.order.application.ports.output.message.publisher;

import com.sam.common.event.DomainEventPublisher;
import com.sam.order.domain.event.OrderCreated;

public interface OrderCreatedEventPublisher extends DomainEventPublisher<OrderCreated> {

}