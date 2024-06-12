package com.sam.order.application.message.impl;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.sam.order.application.dto.message.PaymentDeclinedMessage;
import com.sam.order.application.message.handler.PaymentDeclinedMessageHandler;
import com.sam.order.application.ports.input.message.PaymentDeclinedMessageProcessor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Validated
@Service
public class PaymentDeclinedMessageProcessorImpl implements PaymentDeclinedMessageProcessor {
    private final PaymentDeclinedMessageHandler handler;

    @Override
    public void declinePayment(PaymentDeclinedMessage declinePayment) {
        handler.handle(declinePayment);
        log.info( "Payment declined for the order with id : {}", declinePayment.getOrderId() );
    }

}
