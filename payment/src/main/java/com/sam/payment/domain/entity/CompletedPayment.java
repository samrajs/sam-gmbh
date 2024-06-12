package com.sam.payment.domain.entity;

import com.sam.payment.domain.valueobject.PaymentStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class CompletedPayment extends Payment {
    //@Builder.Default
    //private PaymentStatus paymentStatus = PaymentStatus.COMPLETED;

    /*public void initPayment() {
        paymentStatus = PaymentStatus.COMPLETED;
    }*/
}
