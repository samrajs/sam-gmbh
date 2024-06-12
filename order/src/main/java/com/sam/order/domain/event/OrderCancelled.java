package com.sam.order.domain.event;

import java.time.ZonedDateTime;

import com.sam.common.event.DomainEvent;
import com.sam.order.domain.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderCancelled implements DomainEvent<Order> {
    private final Order order;
    private final ZonedDateTime createAt;
}
