package com.example.spring_kafka_messaging.service;


import com.example.spring_kafka_messaging.security.JwtUtil;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final JwtUtil jwtUtil;
    private final String TOPIC = "event_topic"; // Kafka topic name

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate, JwtUtil jwtUtil) {
        this.kafkaTemplate = kafkaTemplate;
        this.jwtUtil = jwtUtil;
    }

    public void sendMessage(String serviceName, String message) {
        // Generate JWT Token
        String jwtToken = jwtUtil.generateToken(serviceName);

        // Combine JWT and message
        String messageWithToken = jwtToken + "|" + message;

        // Send message to Kafka
        System.out.println("🔹 PRODUCER: Sending message with JWT: " + message);
        kafkaTemplate.send(TOPIC, messageWithToken);
    }
}
