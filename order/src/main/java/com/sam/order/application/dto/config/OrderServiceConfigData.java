package com.sam.order.application.dto.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "order-service")
public class OrderServiceConfigData {
    private String orderCreatedTopicName;
    private String orderCancelledTopicName;
    private String paymentDeniedTopicName;
}
