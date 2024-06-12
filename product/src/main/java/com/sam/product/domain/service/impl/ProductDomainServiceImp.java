package com.sam.product.domain.service.impl;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.sam.product.domain.entity.Product;
import com.sam.product.domain.event.ProductAvailable;
import com.sam.product.domain.event.ProductCreated;
import com.sam.product.domain.event.ProductPhasingOut;
import com.sam.product.domain.service.ProductDomainService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductDomainServiceImp implements ProductDomainService {
    private final String UTC = "UTC";

    @Override
    public ProductCreated validateAndInitProduct(Product product) {
        product.validate();
        product.init();
        log.info("Product validated and initiated");
        return new ProductCreated(product, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    @Override
    public ProductAvailable makeItAvailable(Product product) {
        product.makeItAvailable();
        log.info("Product is made avilable");
        return new ProductAvailable(product, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    @Override
    public ProductPhasingOut phaseOut(Product product) {
        product.phaseItOut();
        log.info("Product is phased out");
        return new ProductPhasingOut(product, ZonedDateTime.now(ZoneId.of(UTC)));
    }
}