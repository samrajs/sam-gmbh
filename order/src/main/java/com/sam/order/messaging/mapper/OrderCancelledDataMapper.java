package com.sam.order.messaging.mapper;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sam.order.domain.event.OrderCancelled;
import com.sam.order.messaging.dto.OrderPayload;
import com.sam.order.messaging.entity.OutboxEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderCancelledDataMapper {
    private final ObjectMapper objectMapper;

    public OutboxEntity toOutboxEntity( OrderCancelled event ) {
        return OutboxEntity.builder()
            .id( UUID.randomUUID() )
            .aggregateType( "order" )
            .aggregateId( event.getOrder().getId().getValue() )
            .payload( toJson( toOrderPayload( event ) ) )
            .build();
    }

    public OrderPayload toOrderPayload( OrderCancelled event ) {
        return OrderPayload.builder()
                .id( event.getOrder().getId().getValue().toString() )
                .customerId( event.getOrder().getCustomerId().getValue().toString() )
                .orderAmount( event.getOrder().getOrderAmount().getAmount() )
                .status( "CANCELLED" )
                .reason( "" )
                .build();
    }

    private String toJson( OrderPayload payload ) {
        try {
            return objectMapper.writeValueAsString( payload );
        } catch (JsonProcessingException e) {
            log.error("Could not create OrderCancelledPayload object for order id: {}",
                    payload.getId(), e);
            throw new RuntimeException("Could not create OrderCancelledPayload object for order id: " +
            payload.getId(), e);
        }
    }

}