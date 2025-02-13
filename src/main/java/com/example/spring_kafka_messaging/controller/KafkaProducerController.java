package com.example.spring_kafka_messaging.controller;

import com.example.spring_kafka_messaging.service.KafkaProducerService;



import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class KafkaProducerController {

    private final KafkaProducerService kafkaProducerService;

    public KafkaProducerController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @GetMapping("/send")
    public String sendMessage(@RequestParam String serviceName, @RequestParam String message) {
        kafkaProducerService.sendMessage(serviceName, message);
        return "🔹 Message sent to Kafka securely: " + message;
    }
}
