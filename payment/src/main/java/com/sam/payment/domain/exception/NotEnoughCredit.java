package com.sam.payment.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sam.payment.domain.valueobject.Money;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotEnoughCredit extends RuntimeException {
    public NotEnoughCredit( Money credit, Money orderAmount ) {
        super(String.format( "Not enough credit (%s) for the order amount (%s)", credit, orderAmount ) );
    }
}