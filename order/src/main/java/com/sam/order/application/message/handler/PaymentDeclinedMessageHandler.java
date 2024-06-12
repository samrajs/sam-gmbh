package com.sam.order.application.message.handler;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.sam.order.application.dto.message.PaymentDeclinedMessage;
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
public class PaymentDeclinedMessageHandler {
    private final OrderDomainService domainService;
    private final OrderRepository repository;

    @Transactional
    public void handle( PaymentDeclinedMessage declinePayment ) {
        Optional<Order> order = repository.findById( OrderId.from( declinePayment.getOrderId() ) );
        order.orElseThrow( () -> new OrderNotFound( OrderId.from( declinePayment.getOrderId() ) ) );

        domainService.declinePayment( order.get() );
        log.info( "Order with order id {} has been declined payment", declinePayment.getOrderId() );

    }

}
