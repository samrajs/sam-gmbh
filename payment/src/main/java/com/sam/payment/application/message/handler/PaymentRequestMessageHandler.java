package com.sam.payment.application.message.handler;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sam.payment.application.dto.mapper.PaymentRequestMapper;
import com.sam.payment.application.dto.message.PaymentRequestMessage;
import com.sam.payment.application.ports.output.message.publisher.PaymentCompletedMessagePublisher;
import com.sam.payment.application.ports.output.message.publisher.PaymentDeclinedMessagePublisher;
import com.sam.payment.application.ports.output.repository.CreditRepository;
import com.sam.payment.application.ports.output.repository.PaymentRepository;
import com.sam.payment.domain.entity.CompletedPayment;
import com.sam.payment.domain.entity.Credit;
import com.sam.payment.domain.entity.DeclinedPayment;
import com.sam.payment.domain.entity.Payment;
import com.sam.payment.domain.event.PaymentCompleted;
import com.sam.payment.domain.event.PaymentDeclined;
import com.sam.payment.domain.exception.CreditNotFound;
import com.sam.payment.domain.service.PaymentDomainService;
import com.sam.payment.domain.valueobject.CustomerId;
import com.sam.payment.domain.valueobject.OrderId;

import io.vavr.control.Either;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentRequestMessageHandler {
    private final PaymentDomainService domainService;
    private final CreditRepository creditRepository;
    private final PaymentRepository paymentRepository;
    private final PaymentCompletedMessagePublisher paymentCompletedPublisher;
    private final PaymentDeclinedMessagePublisher paymentDeclinedPublisher;
    private final PaymentRequestMapper mapper;

    @Transactional
    public void handle( PaymentRequestMessage message ) {
        CustomerId customerId = CustomerId.from( message.getCustomerId() );
        OrderId orderId = OrderId.from( message.getOrderId() );

        if ( paymentRepository.findByOrderId( orderId ).isPresent() ) {
            log.info( "Payment already exists for the order with order id: {}", message.getOrderId() );
            return;
        }

        Optional<Credit> credit = creditRepository.findById( customerId );
        credit.orElseThrow( () -> new CreditNotFound(customerId) );

        Payment payment = mapper.paymentRequestToPayment(message);

        log.info( "Credit before debiting: {}", credit.get());

        Either<PaymentDeclined, PaymentCompleted> result = domainService.subtractCredit(credit.get(), payment);
        log.info( "Credit after debiting: {}", credit.get());

        creditRepository.save( credit.get() );
        

        result.peek(this::publish);
        result.peekLeft(this::publish);

        result.peek( event -> save(event.getPayment()) );
        result.peekLeft( event -> save(event.getPayment()) );

    }

    private void publish(PaymentCompleted event) {
        paymentCompletedPublisher.publish(event);
    }

    private void publish(PaymentDeclined event) {
        paymentDeclinedPublisher.publish(event);
    }

    private void save( CompletedPayment payment ) {
        paymentRepository.save(payment);
    }

    private void save( DeclinedPayment payment ) {
        paymentRepository.save(payment);
    }
}
