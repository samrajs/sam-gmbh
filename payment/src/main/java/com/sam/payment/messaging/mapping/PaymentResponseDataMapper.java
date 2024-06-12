package com.sam.payment.messaging.mapping;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sam.payment.domain.event.PaymentCancelled;
import com.sam.payment.domain.event.PaymentCompleted;
import com.sam.payment.domain.event.PaymentDeclined;
import com.sam.payment.messaging.dto.PaymentPayload;
import com.sam.payment.messaging.entity.OutboxEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
@RequiredArgsConstructor
public class PaymentResponseDataMapper {
    private final ObjectMapper objectMapper;

    /*public PaymentRequestMessage orderCreatedAvroModelToPaymentRequest( OrderCreatedAvroModel avroModel ) {
        return PaymentRequestMessage.builder()
                    .customerId( UUID.fromString( avroModel.getCustomerId() ) )
                    .orderId( UUID.fromString( avroModel.getId() ) )
                    .orderAmount( avroModel.getOrderAmount() )
                    .build();
    }

    public PaymentCancellationMessage orderCancelledAvroModelToPaymentCancel( OrderCancelledAvroModel avroModel ) {
        return PaymentCancellationMessage.builder()
                    .customerId( UUID.fromString( avroModel.getCustomerId() ) )
                    .orderId( UUID.fromString( avroModel.getId() ) )
                    .orderAmount( avroModel.getOrderAmount() )
                    .build();
    }*/

    public OutboxEntity toOutbox( PaymentCompleted event ) {
        return OutboxEntity.builder()
                .id( UUID.randomUUID() )
                .aggregateType( "payment" )
                .aggregateId( event.getPayment().getOrderId().getValue() )
                .payload( toJson( toPaymentPayload( event ) ) )
                .build();
    }

    public OutboxEntity toOutbox( PaymentCancelled event ) {
        return OutboxEntity.builder()
                .id( UUID.randomUUID() )
                .aggregateType( "payment" )
                .aggregateId( event.getPayment().getOrderId().getValue() )
                .payload( toJson( toPaymentPayload( event ) ) )
                .build();
    }

    public OutboxEntity toOutbox( PaymentDeclined event ) {
        return OutboxEntity.builder()
                .id( UUID.randomUUID() )
                .aggregateType( "payment" )
                .aggregateId( event.getPayment().getOrderId().getValue() )
                .payload( toJson( toPaymentPayload( event ) ) )
                .build();
    }

    private PaymentPayload toPaymentPayload( PaymentCompleted event ) {
        return PaymentPayload.builder()
                .id( event.getPayment().getOrderId().getValue().toString() )
                .customerId( event.getPayment().getCustomerId().getValue().toString() )
                .orderAmount( event.getPayment().getOrderAmount().getAmount() )
                .status( "PAID" )
                .build();
    }

    private PaymentPayload toPaymentPayload( PaymentCancelled event ) {
        return PaymentPayload.builder()
                .id( event.getPayment().getOrderId().getValue().toString() )
                .customerId( event.getPayment().getCustomerId().getValue().toString() )
                .orderAmount( event.getPayment().getOrderAmount().getAmount() )
                .status( "CANCELLED" )
                .build();
    }

    private PaymentPayload toPaymentPayload( PaymentDeclined event ) {
        return PaymentPayload.builder()
                .id( event.getPayment().getOrderId().getValue().toString() )
                .customerId( event.getPayment().getCustomerId().getValue().toString() )
                .orderAmount( event.getPayment().getOrderAmount().getAmount() )
                .status( "DECLINED" )
                .build();
    }

    private String toJson( PaymentPayload payload ) {
        try {
            return objectMapper.writeValueAsString( payload );
        } catch (JsonProcessingException e) {
            log.error("Could not create PaymentPayload object for order id: {}",
                    payload.getId(), e);
            throw new RuntimeException("Could not create PaymentPayload object for order id: " + payload.getId(), e);
        }
    }

}
