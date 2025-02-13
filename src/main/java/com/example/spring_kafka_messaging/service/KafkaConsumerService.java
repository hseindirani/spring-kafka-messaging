package com.example.spring_kafka_messaging.service;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "event_topic", groupId = "my-group")
    public void listen(String message) {
        System.out.println("✅ CONSUMER: Received Message from Kafka: " + message);
    }
}
