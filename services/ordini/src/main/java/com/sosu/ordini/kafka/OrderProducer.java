package com.sosu.ordini.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    @Autowired
    private KafkaTemplate<String, OrderConfirmation> kafkaTemplate;

    public void sendConfermaOrdine(OrderConfirmation orderConfirmation) {
        Message<OrderConfirmation> message = MessageBuilder
                .withPayload(orderConfirmation)
                .setHeader(KafkaHeaders.TOPIC, "order-topic")
                .build();
        kafkaTemplate.send(message);
    }

}
