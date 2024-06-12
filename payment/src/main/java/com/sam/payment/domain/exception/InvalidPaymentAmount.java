package com.sam.payment.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sam.payment.domain.valueobject.Money;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidPaymentAmount extends RuntimeException {
    public InvalidPaymentAmount( Money orderAmount ) {
        super(String.format( "Invalid order amount : %s", orderAmount ) );
    }
}