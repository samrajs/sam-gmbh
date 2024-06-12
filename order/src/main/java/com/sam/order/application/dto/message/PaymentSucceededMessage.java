package com.sam.order.application.dto.message;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PaymentSucceededMessage {
    private UUID orderId;
    private UUID customerId;
    private BigDecimal orderAmount;
}
