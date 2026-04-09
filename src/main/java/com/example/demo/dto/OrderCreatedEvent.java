package com.example.demo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreatedEvent {	
	private Long orderId;
	private Long userId;
	private List<OrderItemDto> items;
	private Double totalAmount;
	private String status;
	private String PaymentType;
}
