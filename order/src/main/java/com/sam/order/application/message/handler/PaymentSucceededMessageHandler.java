package com.sam.order.application.message.handler;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.sam.order.application.dto.message.PaymentDeclinedMessage;
import com.sam.order.application.dto.message.PaymentSucceededMessage;
import com.sam.order.application.ports.output.repository.OrderRepository;
import com.sam.order.domain.entity.Order;
import com.sam.order.domain.exception.OrderNotFound;
import com.sam.order.domain.service.OrderDomainService;
import com.sam.order.domain.valueobject.OrderId;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class PaymentSucceededMessageHandler {
    private final OrderDomainService domainService;
    private final OrderRepository repository;

    @Transactional
    public void handle( PaymentSucceededMessage succeededPayment ) {
        Optional<Order> order = repository.findById( OrderId.from( succeededPayment.getOrderId() ) );
        order.orElseThrow( () -> new OrderNotFound( OrderId.from( succeededPayment.getOrderId() ) ) );

        domainService.pay( order.get() );
        repository.save( order.get() );
        log.info( "Order with order id {} has been paid", succeededPayment.getOrderId() );
    }

}
