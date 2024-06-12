package com.sam.payment.dataaccess.adapter;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sam.payment.application.ports.output.repository.PaymentRepository;
import com.sam.payment.dataaccess.entity.PaymentEntity;
import com.sam.payment.dataaccess.mapper.PaymentDataAccessMapper;
import com.sam.payment.dataaccess.repository.PaymentJpaRepository;
import com.sam.payment.domain.entity.Payment;
import com.sam.payment.domain.valueobject.OrderId;
import com.sam.payment.domain.valueobject.PaymentId;
import com.sam.payment.domain.valueobject.PaymentStatus;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static io.vavr.API.*;
import static io.vavr.Predicates.is;

@Slf4j
@RequiredArgsConstructor
@Component
public class PaymentRepositoryImpl implements PaymentRepository {
    private final PaymentDataAccessMapper mapper;
    private final PaymentJpaRepository repository;

    @Override
    public Payment save(Payment payment) {
        return mapper.paymentEntityToPayment(repository.save(mapper.paymentToPaymentEntity(payment)));
    }

    @Override
    public Optional<Payment> findById(PaymentId paymentId) {
        Optional<PaymentEntity> paymentEntity = repository.findById( paymentId.getValue() );

        return toPayment(paymentEntity);
    }

    @Override
    public Optional<Payment> findByOrderId(OrderId orderId) {
        //Optional<PaymentEntity> paymentEntity = repository.findByOrderId( orderId.getValue() );

        //return toPayment(paymentEntity);

        return repository.findByOrderId( orderId.getValue() ).map( mapper::paymentEntityToPayment );
    }

    @Override
    public Optional<Payment> findPaidOrderByOrderId(OrderId orderId) {
        Optional<PaymentEntity> paymentEntity = repository.findByOrderIdAndStatus( orderId.getValue(), PaymentStatus.COMPLETED );

        return toPayment(paymentEntity);
    }

    private Optional<Payment> toPayment( Optional<PaymentEntity> paymentEntity ) {
        log.info( "Payment entity present: {}", paymentEntity.isPresent() );
        return Optional.ofNullable(Match( paymentEntity.isPresent() ).of(
            Case($(is(true)), mapper.paymentEntityToPayment(paymentEntity.get())),
            Case($(is(false)), ()-> null)
        ));
    }

}
