package com.example.demo.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.dto.OrderCreatedEvent;

@Service
public class OrderEventPublisher {
	
	private final KafkaTemplate<String, Object> kafkaTemplate;
	
	public OrderEventPublisher(KafkaTemplate<String, Object> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void publishOrderCreatedEvent(OrderCreatedEvent event) {
		kafkaTemplate.send("order-created-topic", event);
		System.out.println("Event Published to Kafka : " + event.getOrderId());
	}
}
