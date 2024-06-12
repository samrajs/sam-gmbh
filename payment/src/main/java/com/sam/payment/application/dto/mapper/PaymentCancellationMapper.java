package com.sam.payment.application.dto.mapper;

import org.springframework.stereotype.Component;

import com.sam.payment.application.dto.message.PaymentCancellationMessage;
import com.sam.payment.domain.entity.CancelledPayment;
import com.sam.payment.domain.valueobject.CustomerId;
import com.sam.payment.domain.valueobject.Money;
import com.sam.payment.domain.valueobject.OrderId;

@Component
public class PaymentCancellationMapper {
    public CancelledPayment paymentCancellationToCancelledPayment( PaymentCancellationMessage message ) {
        return CancelledPayment.builder()
                .customerId( CustomerId.from( message.getCustomerId() ) )
                .orderId( OrderId.from( message.getOrderId() ) )
                .orderAmount( new Money( message.getOrderAmount() ) )
                .build();
    }
}
