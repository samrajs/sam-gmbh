package com.sam.payment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sam.payment.domain.service.PaymentDomainService;
import com.sam.payment.domain.service.impl.PaymentDomainServiceImpl;

@Configuration
public class BeanConfiguration {
    @Bean
    public PaymentDomainService productDomainService() {
        return new PaymentDomainServiceImpl();
    }

}
