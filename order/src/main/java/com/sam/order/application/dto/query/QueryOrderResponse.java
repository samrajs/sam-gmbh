package com.sam.order.application.dto.query;

import java.math.BigDecimal;

import com.sam.order.application.dto.common.OrderAddress;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class QueryOrderResponse {
    private String customerId;
    private String customerName;
    private OrderAddress address;
    private BigDecimal orderAmount;
    private String status;
}
