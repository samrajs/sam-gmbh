package com.sam.payment.domain.service;

import java.util.Optional;

import com.sam.payment.domain.entity.CancelledPayment;
import com.sam.payment.domain.entity.CompletedPayment;
import com.sam.payment.domain.entity.Credit;
import com.sam.payment.domain.entity.Payment;
import com.sam.payment.domain.event.DoNotPublish;
import com.sam.payment.domain.event.PaymentCancelled;
import com.sam.payment.domain.event.PaymentCompleted;
import com.sam.payment.domain.event.PaymentDeclined;
import com.sam.payment.domain.valueobject.Money;

import io.vavr.control.Either;

public interface PaymentDomainService {
    void addCredit( Credit credit, Money money );
    Either<PaymentDeclined, PaymentCompleted> subtractCredit( Credit credit, Payment payment );
    DoNotPublish cancelPayment( Credit credit, CancelledPayment payment );
    PaymentCancelled cancelPayment( Credit credit, CompletedPayment payment );
}
