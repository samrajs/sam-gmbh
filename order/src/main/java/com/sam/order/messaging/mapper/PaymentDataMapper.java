package com.sam.order.messaging.mapper;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sam.order.application.dto.message.PaymentDeclinedMessage;
import com.sam.order.application.dto.message.PaymentSucceededMessage;
import com.sam.order.application.exception.OrderSystemException;
import com.sam.order.messaging.dto.PaymentPayload;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PaymentDataMapper {
    private final ObjectMapper objectMapper;
    
    public PaymentDeclinedMessage toPaymentDeclinedMessage( PaymentPayload payload ) {
        return PaymentDeclinedMessage.builder()
                .orderId( UUID.fromString( payload.getId() ) )
                .orderAmount( payload.getOrderAmount() )
                .reason( payload.getReason() )
                .build();
    }

    public PaymentSucceededMessage toPaymentSucceededMessage( PaymentPayload payload ) {
        return PaymentSucceededMessage.builder()
                .orderId( UUID.fromString( payload.getId() ) )
                .orderAmount( payload.getOrderAmount() )
                .build();
    }

    public PaymentPayload toPaymentPayload( String payload ) {
        return Try.of( () -> objectMapper.readValue(payload, PaymentPayload.class))
            .getOrElseThrow(t -> new OrderSystemException("Error in converting to PaymentPayload", t));
    }
}