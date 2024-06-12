package com.sam.order.application.message.impl;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.sam.order.application.dto.message.PaymentSucceededMessage;
import com.sam.order.application.message.handler.PaymentSucceededMessageHandler;
import com.sam.order.application.ports.input.message.PaymentSucceededMessageProcessor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Validated
@Service
public class PaymentSucceededMessageProcessorImpl implements PaymentSucceededMessageProcessor {
    private final PaymentSucceededMessageHandler processor;

    @Override
    public void paymentSucceded( PaymentSucceededMessage message ) {
        log.info( "Payment succeeded for the order with id : {}", message.getOrderId() );
        processor.handle(message);
    }

}
