package com.sam.product.application;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties( prefix = "product-service" )
public class ProductServiceConfigData {
    private String productCreatedTopicName;
}
