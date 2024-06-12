package com.sam.order.application.ports.output.repository;

import java.util.Optional;

import com.sam.order.domain.entity.Customer;
import com.sam.order.domain.valueobject.CustomerId;

public interface CustomerRepository {
    Optional<Customer> findById( CustomerId id );
}
