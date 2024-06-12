package com.sam.product.messaging.publisher;

import org.springframework.stereotype.Component;

//import com.sam.infrastructure.kafka.producer.KafkaMessageHelper;
//import com.sam.infrastructure.kafka.producer.service.KafkaProducer;
//import com.sam.infrastructure.kafka.system.product.avro.model.ProductCreatedAvroModel;
//import com.sam.product.application.ProductServiceConfigData;
import com.sam.product.application.ports.output.message.publisher.ProductCreatedMessagePublisher;
import com.sam.product.domain.event.ProductCreated;
import com.sam.product.messaging.entity.OutboxEntity;
import com.sam.product.messaging.mapping.ProductMessagingDataMapper;
import com.sam.product.messaging.repository.OutboxJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductCreatedOutboxPublisher implements ProductCreatedMessagePublisher {
    private final ProductMessagingDataMapper mapper;
    private final OutboxJpaRepository repository;
    //private final KafkaProducer<String, ProductCreatedAvroModel> producer;
    //private final KafkaMessageHelper helper;
    //private final ProductServiceConfigData config;

    @Override
    public void publish(ProductCreated domainEvent) {
        String productId = domainEvent.getProduct().getId().getValue().toString();
        log.info( "Product create event to be published for {}", productId );
        OutboxEntity outbox = mapper.toOutbox(domainEvent);

        repository.save(outbox);
    }
    
    /*@Override
    public void publish(ProductCreated domainEvent) {
        String productId = domainEvent.getProduct().getId().getValue().toString();

        log.info( "Product create event to be published for {}", productId );
        try {
            ProductCreatedAvroModel productCreatedAvroModel = mapper.productCreatedEventToProductCreatedAvroModel(domainEvent);

            producer.send(config.getProductCreatedTopicName(), 
                    productId, 
                    productCreatedAvroModel, 
                    helper.getKafkaCallback(config.getProductCreatedTopicName(), 
                            productCreatedAvroModel, productId, "ProductCreatedAvroModel"));
            log.info("ProductCreated event published for the product with product id: {}", productId);
        } catch( Exception e ) {
            log.error("Error while sending ProductCreated event for the product with product id: {}, error: {}", productId, e.getMessage());
        }
    }*/

    
}
