package com.sam.product.domain.exception;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProductTooCostly extends RuntimeException {
    public ProductTooCostly(String productName, BigDecimal price ) {
        super(String.format( "Product %s price %s is too costly", productName, price));
    }
}
