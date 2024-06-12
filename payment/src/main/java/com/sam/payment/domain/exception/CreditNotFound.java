package com.sam.payment.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sam.payment.domain.valueobject.CustomerId;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CreditNotFound extends RuntimeException {
    public CreditNotFound( CustomerId customerId ) {
        super(String.format( "Credit for the customer with id %s is not found", customerId ) );
    }
}