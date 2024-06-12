package com.sam.payment.dataaccess.mapper;

import org.springframework.stereotype.Component;

import com.sam.payment.dataaccess.entity.PaymentEntity;
import com.sam.payment.domain.entity.CancelledPayment;
import com.sam.payment.domain.entity.CompletedPayment;
import com.sam.payment.domain.entity.DeclinedPayment;
import com.sam.payment.domain.entity.Payment;
import com.sam.payment.domain.valueobject.CustomerId;
import com.sam.payment.domain.valueobject.Money;
import com.sam.payment.domain.valueobject.OrderId;
import com.sam.payment.domain.valueobject.PaymentId;

import lombok.extern.slf4j.Slf4j;

import static io.vavr.API.*;
import static com.sam.payment.domain.valueobject.PaymentStatus.*;

@Slf4j
@Component
public class PaymentDataAccessMapper {

    public PaymentEntity paymentToPaymentEntity( Payment payment ) {
        log.info( "Payment : {}", payment );
        return PaymentEntity.builder()
                .id( payment.getId().getValue() )
                .customerId( payment.getCustomerId().getValue() )
                .orderAmount( payment.getOrderAmount().getAmount() )
                .orderId( payment.getOrderId().getValue() )
                .status( payment.getPaymentStatus() )
                .build();
    }

    public Payment paymentEntityToPayment( PaymentEntity entity ) {
        log.info( "Payment entity : {}", entity );
        return Match( entity.getStatus() ).of(
            Case($(COMPLETED), toCompletedPayment(entity)),
            Case($(DECLINED), toDeclinedPayment(entity)),
            Case($(CANCELLED), toCancelledPayment(entity))
        );
    }

    public CompletedPayment toCompletedPayment( PaymentEntity entity ) {
        return CompletedPayment.builder()
                .id(PaymentId.from(entity.getId()))
                .orderId(OrderId.from( entity.getOrderId()))
                .customerId(CustomerId.from(entity.getCustomerId()))
                .orderAmount(new Money( entity.getOrderAmount()))
                .build();
    }

    public DeclinedPayment toDeclinedPayment( PaymentEntity entity ) {
        return DeclinedPayment.builder()
                .id(PaymentId.from(entity.getId()))
                .orderId(OrderId.from( entity.getOrderId()))
                .customerId(CustomerId.from(entity.getCustomerId()))
                .orderAmount(new Money( entity.getOrderAmount()))
                .build();
    }

    public CancelledPayment toCancelledPayment( PaymentEntity entity ) {
        return CancelledPayment.builder()
                .id(PaymentId.from(entity.getId()))
                .orderId(OrderId.from( entity.getOrderId()))
                .customerId(CustomerId.from(entity.getCustomerId()))
                .orderAmount(new Money( entity.getOrderAmount()))
                .build();
    }
}
