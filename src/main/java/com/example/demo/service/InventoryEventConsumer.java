package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repositories.OrderRepository;
import com.example.demo.dto.InventoryEvent;
import com.example.demo.entity.Order;

@Service
public class InventoryEventConsumer {

	@Autowired
	private OrderRepository orderRepository;

	@KafkaListener(topics = "inventory-events-topic", groupId = "order-group")
	@Transactional
	public void consumeInventoryEvent(InventoryEvent event) {
		System.out.println("-----> Order Service Received Event: " + event.getStatus() + " for Order: " + event.getOrderId());
		Order order = orderRepository.findById(event.getOrderId())
				.orElseThrow(() -> new RuntimeException("Order not found"));

		if ("ALLOCATED".equals(event.getStatus())) {
			order.setStatus("CONFIRMED");
			System.out.println("Order " + event.getOrderId() + " confirmed. Stock allocated.");
		} else if ("FAILED".equals(event.getStatus())) {
			order.setStatus("CANCELLED");
			System.out.println("Order " + event.getOrderId() + " cancelled due to: " + event.getMessage());
		}
		orderRepository.save(order);
		System.out.println("-----> Order status updated in DB!");
	}

}
