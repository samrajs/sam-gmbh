package com.sam.order.domain.service;

import com.sam.order.domain.entity.Order;
import com.sam.order.domain.event.OrderCancelled;
import com.sam.order.domain.event.OrderCreated;

public interface OrderDomainService {
    OrderCreated validateAndInit( Order order );
    Order pay( Order order );
    Order declinePayment( Order order );
    OrderCancelled cancel( Order order );
}
