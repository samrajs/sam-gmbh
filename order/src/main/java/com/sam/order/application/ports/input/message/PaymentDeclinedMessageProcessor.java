package com.sam.order.application.ports.input.message;

import com.sam.order.application.dto.message.PaymentDeclinedMessage;

public interface PaymentDeclinedMessageProcessor {
    void declinePayment( PaymentDeclinedMessage declinePayment );
}
