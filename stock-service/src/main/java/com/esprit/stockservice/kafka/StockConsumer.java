package com.esprit.stockservice.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StockConsumer {

    @KafkaListener(topics = "article-events", groupId = "stock-group")
    public void consume(String message) {
        System.out.println("Received Kafka message in Stock Service: " + message);
        // Parse message and update stock accordingly
    }
}