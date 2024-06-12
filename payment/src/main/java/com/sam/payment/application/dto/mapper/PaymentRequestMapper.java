package com.sam.payment.application.dto.mapper;

import org.springframework.stereotype.Component;

import com.sam.payment.application.dto.message.PaymentRequestMessage;
import com.sam.payment.domain.entity.Payment;
import com.sam.payment.domain.valueobject.CustomerId;
import com.sam.payment.domain.valueobject.Money;
import com.sam.payment.domain.valueobject.OrderId;

@Component
public class PaymentRequestMapper {
    public Payment paymentRequestToPayment( PaymentRequestMessage message ) {
        return Payment.builder()
                        .customerId( CustomerId.from( message.getCustomerId() ) )
                        .orderId( OrderId.from( message.getOrderId() ) )
                        .orderAmount( new Money( message.getOrderAmount() ) )
                        .build();
    }
}
