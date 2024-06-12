package com.sam.order.application.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.sam.order.application.dto.create.CreateOrderCommand;
import com.sam.order.application.dto.create.CreateOrderResponse;
import com.sam.order.application.dto.update.CancelOrderCommand;
import com.sam.order.application.dto.update.PayOrderCommand;
import com.sam.order.application.ports.input.service.OrderApplicationService;
import com.sam.order.application.service.handler.CancelOrderCommandHandler;
import com.sam.order.application.service.handler.CreateOrderCommandHandler;
import com.sam.order.application.service.handler.PayOrderCommandHandler;

import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Validated
@Service
public class OrderApplicationServiceImpl implements OrderApplicationService {
    private final CreateOrderCommandHandler createOrderCommandHandler;
    private final PayOrderCommandHandler payOrderCommandHandler;
    private final CancelOrderCommandHandler cancelOrderCommandHandler;

    @Override
    @WithSpan(kind = SpanKind.SERVER)
    public CreateOrderResponse createOrder(CreateOrderCommand command) {
        log.info( "Inside createOrder of OrderApplicationServiceImpl");
        return createOrderCommandHandler.createOrder(command);
    }

    @Override
    public void pay(PayOrderCommand command) {
        payOrderCommandHandler.handle(command);
    }

    @Override
    public void cancel(CancelOrderCommand command) {
        cancelOrderCommandHandler.handle(command);
    }

}
