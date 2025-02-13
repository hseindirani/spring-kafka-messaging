package com.example.spring_kafka_messaging.service;




import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String TOPIC = "event_topic"; // Kafka topic name

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        System.out.println("🔹 PRODUCER: Sending message to Kafka: " + message);
        kafkaTemplate.send(TOPIC, message);
    }
}
