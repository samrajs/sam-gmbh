package com.sam.order.messaging.listener;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.sam.infrastructure.kafka.consumer.KafkaConsumer;
import com.sam.order.application.dto.message.PaymentDeclinedMessage;
import com.sam.order.application.dto.message.PaymentSucceededMessage;
import com.sam.order.application.ports.input.message.PaymentDeclinedMessageProcessor;
import com.sam.order.application.ports.input.message.PaymentSucceededMessageProcessor;
import com.sam.order.domain.exception.OrderNotFound;
import com.sam.order.messaging.dto.PaymentPayload;
import com.sam.order.messaging.mapper.PaymentDataMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static io.vavr.API.*;
import static io.vavr.Predicates.*;

@Slf4j
@RequiredArgsConstructor
@Component
public class PaymentKafkaEventListener {
//implements KafkaConsumer<String> {
    private final PaymentDeclinedMessageProcessor declinedProcessor;
    private final PaymentSucceededMessageProcessor successProcessor;
    private final PaymentDataMapper mapper;

    /*@Override
    @KafkaListener(id = "${kafka-consumer-config.payment-consumer-group-id}",
                topics = "${order-service.payment-topic-name}")
    public void receive(@Payload List<String> messages, 
                        @Header(KafkaHeaders.RECEIVED_KEY) List<String> keys, 
                        @Header(KafkaHeaders.RECEIVED_PARTITION) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of payment declined received with keys {}, partitions {} and offsets {}",
                            messages.size(),
                            keys.toString(),
                            partitions.toString(),
                            offsets.toString());
        
        messages.forEach( stringPayload -> {
            PaymentPayload payload = mapper.toPaymentPayload(stringPayload);
            Match( payload.getStatus() ).of(
                Case($(is("PAID")), s -> successPayment(payload)),
                Case($(is("DECLINED")), s ->declinePayment(payload))
            );
        });
    }*/

    //@Override
    @KafkaListener(id = "${kafka-consumer-config.payment-consumer-group-id}",
                topics = "${order-service.payment-topic-name}",
                batch = "false")
    public void receive(@Payload String message, 
                        @Header(KafkaHeaders.RECEIVED_KEY) String key, 
                        @Header(KafkaHeaders.RECEIVED_PARTITION) Integer partition,
                        @Header(KafkaHeaders.OFFSET) Long offset) {
        log.info("{} number of payment declined received with keys {}, partitions {} and offsets {}",
                            1,
                            key,
                            partition,
                            offset);
        
        PaymentPayload payload = mapper.toPaymentPayload(message);
        Match( payload.getStatus() ).of(
            Case($(is("PAID")), s -> successPayment(payload)),
            Case($(is("DECLINED")), s ->declinePayment(payload))
        );
    }

    private boolean successPayment( PaymentPayload payload ) {
        try {
            log.info( "Payment succeeded for the order : {}", payload.getId());
            PaymentSucceededMessage message = mapper.toPaymentSucceededMessage(payload);
            successProcessor.paymentSucceded(message);
        }
        catch( OrderNotFound exception ) {
            log.error("No order found for the order id : {}", payload.getId());
            return false;
        }
        return true;
    }

    private boolean declinePayment( PaymentPayload payload ) {
        try {
            log.info( "Payment declined for the order : {}", payload.getId());
            PaymentDeclinedMessage message = mapper.toPaymentDeclinedMessage(payload);
            declinedProcessor.declinePayment(message);
        }
        catch( OrderNotFound exception ) {
            log.error("No order found for the order id : {}", payload.getId());
            return false;
        }
        return true;
    }
}
