package com.sam.product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sam.product.domain.service.ProductDomainService;
import com.sam.product.domain.service.impl.ProductDomainServiceImp;

@Configuration
public class BeanConfiguration {
    @Bean
    public ProductDomainService productDomainService() {
        return new ProductDomainServiceImp();
    }

}
