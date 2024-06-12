package com.sam.product.application.service.handler;

import org.springframework.stereotype.Component;

import com.sam.product.application.dto.create.CreateProductCommand;
import com.sam.product.application.dto.create.CreateProductResponse;
import com.sam.product.application.dto.mapper.ProductMapper;
import com.sam.product.application.ports.output.message.publisher.ProductCreatedMessagePublisher;
import com.sam.product.application.service.helper.ProductHelper;
import com.sam.product.domain.event.ProductCreated;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateProductCommandHandler {
    private final ProductMapper mapper;
    private final ProductHelper helper;
    private final ProductCreatedMessagePublisher publisher;
    
    public CreateProductResponse createProduct( CreateProductCommand command ) {
        ProductCreated event = helper.persistProduct(command);

        log.info( "Product {} has been created", event.getProduct() );
        publisher.publish(event);

        return mapper.productToCreateProductResponse( event.getProduct() );
    }
}
