package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repositories.OrderItemRepository;
import com.example.demo.Repositories.OrderRepository;
import com.example.demo.Repositories.ProductRepository;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.dto.OrderCreatedEvent;
import com.example.demo.dto.OrderItemDto;
import com.example.demo.dto.OrderRequestDto;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import com.example.demo.entity.Product;
import com.example.demo.entity.Users;

@Service
public class OrderService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderEventPublisher orderEventPublisher;
	
	@Transactional
	public String createOrder(OrderRequestDto orderRequestDto) {
		Order order = new Order();
		List<OrderItem> orderItems = new ArrayList<>();
		double totalAmount = 0.0;
		
		String orderNumber = UUID.randomUUID().toString();
		
		//validate the User
		Long userId = orderRequestDto.getUserId();
		List<OrderItemDto> orderItemDto = orderRequestDto.getOrderItemDto();
		Users user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User is not found"));
		
		//Fetch the product
		for(OrderItemDto orderItem : orderItemDto) {
			OrderItem item = new OrderItem();
			Long productId = orderItem.getProductId();
			int quantity = orderItem.getQuantity();
			Product product = productRepository.findById(productId).orElseThrow(()-> new RuntimeException("Product is not found"));
			Double price = product.getProductPrice();
			Double total = price * quantity;
			totalAmount += total;
			
			item.setQuantity(quantity);
			item.setTotalPrice(total);
			item.setPrice(price);
			item.setProduct(product);
			
			orderItems.add(item);
		}
		
		order.setOrderNumber(orderNumber);
		order.setStatus("NEW");
		order.setTotalAmount(totalAmount);
		order.setCreatedDate(LocalDateTime.now());
		order.setUpdatedDate(LocalDateTime.now());
		order.setUser(user);
		
		orderRepository.save(order);
		
		orderItems.forEach(item -> {
			item.setOrder(order);
			orderItemRepository.save(item);
		});
		
		
		List<OrderItemDto> eventItems = new ArrayList<>();

		for(OrderItemDto dto : orderItemDto){
		    eventItems.add(new OrderItemDto(dto.getProductId(), dto.getQuantity()));
		}

		
		OrderCreatedEvent event = new OrderCreatedEvent();
		event.setOrderId(order.getOrderId());
		event.setUserId(user.getUserId());
		event.setTotalAmount(totalAmount);
		event.setStatus(order.getStatus());
		event.setItems(eventItems);
		
		orderEventPublisher.publishOrderCreatedEvent(event);
		
		return "Order is created";
		
	}
}
