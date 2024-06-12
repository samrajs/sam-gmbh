package com.sam.payment.application.ports.output.repository;

import java.util.Optional;

import com.sam.payment.domain.entity.Payment;
import com.sam.payment.domain.valueobject.OrderId;
import com.sam.payment.domain.valueobject.PaymentId;


public interface PaymentRepository {
    Payment save( Payment payment );

    Optional<Payment> findById( PaymentId paymentId );

    Optional<Payment> findByOrderId( OrderId orderId );

    Optional<Payment> findPaidOrderByOrderId( OrderId orderId );
}
