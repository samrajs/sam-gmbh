package com.sam.payment.application.message.handler;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sam.payment.application.dto.mapper.PaymentCancellationMapper;
import com.sam.payment.application.dto.message.PaymentCancellationMessage;
import com.sam.payment.application.ports.output.message.publisher.PaymentCancelledMessagePublisher;
import com.sam.payment.application.ports.output.repository.CreditRepository;
import com.sam.payment.application.ports.output.repository.PaymentRepository;
import com.sam.payment.domain.entity.CancelledPayment;
import com.sam.payment.domain.entity.CompletedPayment;
import com.sam.payment.domain.entity.Credit;
import com.sam.payment.domain.entity.Payment;
import com.sam.payment.domain.event.DoNotPublish;
import com.sam.payment.domain.event.PaymentCancelled;
import com.sam.payment.domain.exception.CreditNotFound;
import com.sam.payment.domain.service.PaymentDomainService;
import com.sam.payment.domain.valueobject.CustomerId;
import com.sam.payment.domain.valueobject.OrderId;

import static io.vavr.API.*;
import static io.vavr.Predicates.instanceOf;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentCancellationMessageHandler {
    private final PaymentDomainService domainService;
    private final CreditRepository creditRepository;
    private final PaymentRepository paymentRepository;
    private final PaymentCancellationMapper mapper;
    private final PaymentCancelledMessagePublisher publisher;

    @Transactional
    public void handle( PaymentCancellationMessage message ) {
        CustomerId customerId = CustomerId.from( message.getCustomerId() );
        OrderId orderId = OrderId.from( message.getOrderId() );
        /*Optional<Payment> payment = null;

        if ( (payment = paymentRepository.findPaidOrderByOrderId( orderId )).isPresent() ) {
            log.info( "There is no paid order with order id: {}", message.getOrderId() );
            return;
        }*/

        Optional<Credit> credit = creditRepository.findById( customerId );
        credit.orElseThrow( () -> new CreditNotFound(customerId) );

        CancelledPayment payment = Match(paymentRepository.findPaidOrderByOrderId( orderId ).get()).of(
            Case($(instanceOf(CompletedPayment.class)), t -> publish(domainService.cancelPayment(credit.get(), t)).getPayment()),
            Case($(instanceOf(CancelledPayment.class)), t -> publish(domainService.cancelPayment(credit.get(), t)).getPayment()),
            Case($(), publish(new DoNotPublish(mapper.paymentCancellationToCancelledPayment(message), null)).getPayment())
        );


        creditRepository.save(credit.get());
        paymentRepository.save(payment);
        //save( payment );
    }

    private PaymentCancelled publish(PaymentCancelled event ) {
        publisher.publish(event);
        return event;
    }

    private DoNotPublish publish(DoNotPublish event ) {
        return event;
    }
}
