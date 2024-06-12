package com.sam.product.messaging.mapping;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.sam.infrastructure.kafka.system.product.avro.model.ProductCategory;
//import com.sam.infrastructure.kafka.system.product.avro.model.ProductCreatedAvroModel;
//import com.sam.infrastructure.kafka.system.product.avro.model.ProductStatus;
import com.sam.product.domain.entity.Product;
import com.sam.product.domain.event.ProductCreated;
import com.sam.product.messaging.dto.ProductPayload;
import com.sam.product.messaging.entity.OutboxEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class ProductMessagingDataMapper {
    private final ObjectMapper objectMapper;

    public OutboxEntity toOutbox( ProductCreated event ) {
        return OutboxEntity.builder()
                .id( UUID.randomUUID() )
                .aggregateType( "product" )
                .aggregateId( event.getProduct().getId().getValue() )
                .payload( productCreatedPayloadToJson( toPayload( event ) ) )
                .build();
    }

    public ProductPayload toPayload( ProductCreated event ) {
        Product product = event.getProduct();

        return ProductPayload.builder()
                .id( product.getId().getValue().toString() )
                .name( product.getName() )
                .description( product.getDescription() )
                .price( product.getPrice().getAmount() )
                .status( product.getStatus().name() )
                .build();
    }

    private String productCreatedPayloadToJson( ProductPayload payload ) {
        try {
            return objectMapper.writeValueAsString( payload );
        } catch (JsonProcessingException e) {
            log.error("Could not create ProductCreatedPayload object for order id: {}",
                    payload.getId(), e);
            throw new RuntimeException("Could not create ProductCreatedPayload object for order id: " +
            payload.getId(), e);
        }
    }


    /*public ProductCreatedAvroModel productCreatedEventToProductCreatedAvroModel( ProductCreated event ) {
        Product product = event.getProduct();
        
        return ProductCreatedAvroModel.newBuilder()
                .setId( product.getId().getValue().toString() )
                .setName( product.getName() )
                .setDescription( product.getDescription() )
                .setPrice( product.getPrice().getAmount() )
                .setProductCategory( ProductCategory.valueOf( product.getCategory().toString() ) )
                .setProductStatus( ProductStatus.valueOf( product.getStatus().toString() ) ) 
                .setCreatedAt( event.getCreateAt().toInstant() )
                .build();
    }*/

}
