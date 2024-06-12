package com.sam.product.application.service.helper;

import org.springframework.stereotype.Component;

import com.sam.product.application.dto.create.CreateProductCommand;
import com.sam.product.application.dto.mapper.ProductMapper;
import com.sam.product.application.ports.output.repository.ProductRepository;
import com.sam.product.domain.entity.Product;
import com.sam.product.domain.event.ProductCreated;
import com.sam.product.domain.service.ProductDomainService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductHelper {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductDomainService domainService;
    
    @Transactional
    public ProductCreated persistProduct( CreateProductCommand command ) {
        Product product = productMapper.createProductCommandToProduct(command);
        ProductCreated event = domainService.validateAndInitProduct(product);
        saveProduct(product);
        log.info( "Product with product id {} has been created", event.getProduct().getId().getValue() );
        return event;
    }

    private void saveProduct( Product product ) {
        Product productResult = productRepository.save(product);

        if (productResult == null) {
            log.error("Not able to save product");
        }

    }
}
