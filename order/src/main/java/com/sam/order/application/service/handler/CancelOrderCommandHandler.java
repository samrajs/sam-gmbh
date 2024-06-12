package com.sam.order.application.service.handler;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sam.order.application.dto.update.CancelOrderCommand;
import com.sam.order.application.ports.output.message.publisher.OrderCancelledEventPublisher;
import com.sam.order.application.ports.output.repository.OrderRepository;
import com.sam.order.domain.entity.Order;
import com.sam.order.domain.event.OrderCancelled;
import com.sam.order.domain.exception.OrderNotFound;
import com.sam.order.domain.service.OrderDomainService;
import com.sam.order.domain.valueobject.OrderId;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class CancelOrderCommandHandler {
    private final OrderRepository repository;
    private final OrderCancelledEventPublisher publisher;
    private final OrderDomainService domainService;

    public void handle( CancelOrderCommand command ) {
        Optional<Order> order = repository.findById( new OrderId( command.getOrderId() ) );

        order.orElseThrow( () -> new OrderNotFound( OrderId.from( command.getOrderId() ) ));

        OrderCancelled event = domainService.cancel(order.get());

        log.info( "Order with order id {} has been cancelled", event.getOrder().getId().getValue() );
        
        publisher.publish(event);

        log.info( "OrderCancelled event published for order id : {}", event.getOrder().getId().getValue() );
    }
}
