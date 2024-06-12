package com.sam.order.application.service.handler;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sam.order.application.dto.update.PayOrderCommand;
import com.sam.order.application.ports.output.repository.OrderRepository;
import com.sam.order.domain.entity.Order;
import com.sam.order.domain.exception.OrderNotFound;
import com.sam.order.domain.service.OrderDomainService;
import com.sam.order.domain.valueobject.OrderId;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class PayOrderCommandHandler {
    private final OrderRepository repository;
    private final OrderDomainService domainService;

    @Transactional
    public void handle( PayOrderCommand command ) {
        Optional<Order> order = repository.findById( new OrderId( command.getOrderId() ) );

        order.orElseThrow( () -> new OrderNotFound( OrderId.from( command.getOrderId() ) ));

        Order paidOrder = domainService.pay(order.get());

        repository.save( paidOrder );
    }
}