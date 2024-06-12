package com.sam.product.application.ports.output.message.publisher;

import com.sam.common.event.DomainEventPublisher;
import com.sam.product.domain.event.ProductCreated;

public interface ProductCreatedMessagePublisher extends DomainEventPublisher<ProductCreated>{

}
