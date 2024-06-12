package com.sam.payment.dataaccess.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sam.payment.dataaccess.entity.PaymentEntity;
import com.sam.payment.domain.valueobject.PaymentStatus;


@Repository
public interface PaymentJpaRepository extends JpaRepository<PaymentEntity, UUID> {
    Optional<PaymentEntity> findByOrderId(UUID orderId);
    Optional<PaymentEntity> findByOrderIdAndStatus(UUID orderId, PaymentStatus status);

}
