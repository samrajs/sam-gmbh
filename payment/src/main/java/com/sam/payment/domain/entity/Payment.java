package com.sam.payment.domain.entity;

import java.util.UUID;

import com.sam.common.entity.AggregateRoot;
import com.sam.payment.domain.exception.InvalidPaymentAmount;
import com.sam.payment.domain.valueobject.CustomerId;
import com.sam.payment.domain.valueobject.Money;
import com.sam.payment.domain.valueobject.OrderId;
import com.sam.payment.domain.valueobject.PaymentId;
import com.sam.payment.domain.valueobject.PaymentStatus;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@ToString(callSuper = true)
public class Payment extends AggregateRoot<PaymentId> {
    private CustomerId customerId;
    private OrderId orderId;
    private Money orderAmount;
    private PaymentStatus paymentStatus;

    public void initPayment() {
        setId( PaymentId.from( UUID.randomUUID() ));
    }

    public void validatePayment() {
        if ( orderAmount == null || !orderAmount.isGreaterThanZero() ) {
            throw new InvalidPaymentAmount(orderAmount);
        }
    }

    /*public void updatePaymentStatus( PaymentStatus status ) {
        paymentStatus = status;
    }*/

    public CompletedPayment success() {
        return CompletedPayment.builder()
                .id( getId() )
                .customerId(customerId)
                .orderId( orderId )
                .orderAmount(orderAmount)
                .paymentStatus( PaymentStatus.COMPLETED )
                .build();

    }

    public DeclinedPayment declined() {
        return DeclinedPayment.builder()
                .id( getId() )
                .customerId(customerId)
                .orderId( orderId )
                .orderAmount(orderAmount)
                .paymentStatus( PaymentStatus.DECLINED )
                .build();

    }

    public CancelledPayment cancelled() {
        return CancelledPayment.builder()
                .id( getId() )
                .customerId(customerId)
                .orderId( orderId )
                .orderAmount(orderAmount)
                .build();

    }

    /*public PaymentStatus getPaymentStatus() {
        return null;
    }*/
}
