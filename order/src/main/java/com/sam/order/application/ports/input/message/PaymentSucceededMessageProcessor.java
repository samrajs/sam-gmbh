package com.sam.order.application.ports.input.message;

import com.sam.order.application.dto.message.PaymentSucceededMessage;

public interface PaymentSucceededMessageProcessor {
    void paymentSucceded( PaymentSucceededMessage message );
}