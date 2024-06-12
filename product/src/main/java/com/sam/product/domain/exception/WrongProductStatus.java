package com.sam.product.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sam.product.domain.valueobject.ProductStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongProductStatus extends RuntimeException {
    public WrongProductStatus( ProductStatus currentStatus, ProductStatus newStatus ) {
        super(String.format("Transition from %s to %s is not allowed", currentStatus, newStatus));
    }

}
