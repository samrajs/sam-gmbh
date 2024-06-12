package com.sam.payment.domain.service.impl;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.sam.payment.domain.entity.CancelledPayment;
import com.sam.payment.domain.entity.CompletedPayment;
import com.sam.payment.domain.entity.Credit;
import com.sam.payment.domain.entity.Payment;
import com.sam.payment.domain.event.DoNotPublish;
import com.sam.payment.domain.event.PaymentCancelled;
import com.sam.payment.domain.event.PaymentCompleted;
import com.sam.payment.domain.event.PaymentDeclined;
import com.sam.payment.domain.exception.NotEnoughCredit;
import com.sam.payment.domain.service.PaymentDomainService;
import com.sam.payment.domain.valueobject.Money;

import io.vavr.control.Either;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PaymentDomainServiceImpl implements PaymentDomainService {
    private final String UTC = "UTC";
    @Override
    public void addCredit(Credit credit, Money money) {
        credit.addCredit(money);
    }

    @Override
    public Either<PaymentDeclined, PaymentCompleted> subtractCredit(Credit credit, Payment payment) {
        try {
            payment.initPayment();
            credit.subtractCredit( payment.getOrderAmount() );
        } catch (NotEnoughCredit notEnoughCredit ) {
            return Either.left(new PaymentDeclined( payment.declined(), ZonedDateTime.now(ZoneId.of(UTC))) );
        }
        log.info( "Credit in subtractCredit : {}", credit );
        return Either.right( new PaymentCompleted( payment.success(), ZonedDateTime.now(ZoneId.of(UTC))) );
    }

    @Override
    public PaymentCancelled cancelPayment(Credit credit, CompletedPayment payment) {
        credit.addCredit( payment.getOrderAmount() );

        return new PaymentCancelled(payment.cancelled(), ZonedDateTime.now(ZoneId.of(UTC)));
    }

    @Override
    public DoNotPublish cancelPayment(Credit credit, CancelledPayment payment) {
        log.info( "The order with order id {} has already been cancelled", payment.getOrderId().getValue() );

        return new DoNotPublish(payment, ZonedDateTime.now(ZoneId.of(UTC)));
    }
}
