package com.juan.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "test-topic", groupId = "group_id")
    public void consumeMessage(String message) {
        System.out.println("Mensaje recibido: " + message);
    }
}