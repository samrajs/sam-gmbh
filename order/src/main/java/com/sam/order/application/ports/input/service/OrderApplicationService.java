package com.sam.order.application.ports.input.service;

import com.sam.order.application.dto.create.CreateOrderCommand;
import com.sam.order.application.dto.create.CreateOrderResponse;
import com.sam.order.application.dto.update.CancelOrderCommand;
import com.sam.order.application.dto.update.PayOrderCommand;

public interface OrderApplicationService {
    CreateOrderResponse createOrder( CreateOrderCommand command);
    void pay(PayOrderCommand command);
    void cancel( CancelOrderCommand command );
}
