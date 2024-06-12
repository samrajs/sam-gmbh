package com.sam.payment.messaging.listener;



import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.sam.infrastructure.kafka.consumer.KafkaConsumer;
import com.sam.payment.application.dto.message.PaymentRequestMessage;
import com.sam.payment.application.ports.input.message.PaymentCancellationMessageProcessor;
import com.sam.payment.application.ports.input.message.PaymentRequestMessageProcessor;
import com.sam.payment.domain.exception.CreditNotFound;
import com.sam.payment.messaging.dto.OrderPayload;
import com.sam.payment.messaging.mapping.PaymentRequestDataMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static io.vavr.API.*;
import static io.vavr.Predicates.*;

@Slf4j
@RequiredArgsConstructor
@Component
public class PaymentKafkaEventListener 
//implements KafkaConsumer<String> 
{
    private final PaymentRequestMessageProcessor paymentRequestMessageProcessor;
    private final PaymentCancellationMessageProcessor paymentCancellationMessageProcessor;
    private final PaymentRequestDataMapper mapper;

    /*@Override
    @KafkaListener(id = "${kafka-consumer-config.payment-consumer-group-id}",
                topics = "${payment-service.order-topic-name}",
                batch = "false"
                )
    public void receive(@Payload List<String> messages, 
                        @Header(KafkaHeaders.RECEIVED_KEY) List<String> keys, 
                        @Header(KafkaHeaders.RECEIVED_PARTITION) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of order message received with keys {}, partitions {} and offsets {}",
                            messages.size(),
                            keys.toString(),
                            partitions.toString(),
                            offsets.toString());
        
        messages.forEach( stringPayload -> {
            log.info( "Payload length : {}", stringPayload.length());
            log.info( "Payload : {}", stringPayload);
            OrderPayload payload = mapper.toOrderPayload(stringPayload);

            Match( payload.getStatus() ).of(
                Case($(is("CREATED")), s -> processPayment(payload)),
                Case($(is("CANCELLED")), s ->cancelPayment(payload))
            );
        });
    }*/
    
    @KafkaListener(id = "${kafka-consumer-config.payment-consumer-group-id}",
    topics = "${payment-service.order-topic-name}",
    batch = "false"
    )
    public void receive(@Payload String message, 
                        @Header(KafkaHeaders.RECEIVED_KEY) String key, 
                        @Header(KafkaHeaders.RECEIVED_PARTITION) Integer partition,
                        @Header(KafkaHeaders.OFFSET) Long offset) {
        log.info("{} number of order message received with keys {}, partitions {} and offsets {}",
                            1,
                            key,
                            partition,
                            offset);
        
        //messages.forEach( stringPayload -> {
            log.info( "Payload length : {}", message.length());
            log.info( "Payload : {}", message);
            OrderPayload payload = mapper.toOrderPayload(message);

            /*Try.run( () -> {
                log.info( "Payment request for the order : {}", payload.getId());
                processor.processPayment(mapper.toPaymentRequest(payload));
            }).onFailure( t -> {} )
            ;*/

            Match( payload.getStatus() ).of(
                Case($(is("CREATED")), s -> processPayment(payload)),
                Case($(is("CANCELLED")), s ->cancelPayment(payload))
            );
        //});
    }

    private boolean processPayment( OrderPayload payload ) {
        try {
            log.info( "Payment request for the order : {}", payload.getId());
            PaymentRequestMessage message = mapper.toPaymentRequest(payload);
            paymentRequestMessageProcessor.processPayment(message);
        }
        catch( CreditNotFound exception ) {
            log.error("No credit found for the order id : {}", payload.getId());
            return false;
        }
        return true;
    }

    private boolean cancelPayment( OrderPayload payload ) {
        try {
            log.info( "Payment cancel for the order : {}", payload.getId());
            
            paymentCancellationMessageProcessor.processPaymentCancellation(mapper.toPaymentCancellation(payload));
        }
        catch( CreditNotFound exception ) {
            log.error("No credit found for the order id : {}", payload.getId());
            return false;
        }
        return true;
    }

}
