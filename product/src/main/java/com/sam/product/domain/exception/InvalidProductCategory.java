package com.sam.product.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sam.product.domain.valueobject.ProductCategory;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidProductCategory extends RuntimeException {
    public InvalidProductCategory( ProductCategory category ) {
        super(String.format( "No plan to sell product category %s as of now", category ) );
    }
}