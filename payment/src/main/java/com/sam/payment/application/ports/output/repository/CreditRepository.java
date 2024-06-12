package com.sam.payment.application.ports.output.repository;

import java.util.Optional;

import com.sam.payment.domain.entity.Credit;
import com.sam.payment.domain.valueobject.CustomerId;

public interface CreditRepository {
    Credit save( Credit credit );

    Optional<Credit> findById( CustomerId customerId );
}