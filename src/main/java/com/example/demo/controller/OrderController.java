package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OrderRequestDto;
import com.example.demo.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping("/orderRequest")
	public void orderRequest(OrderRequestDto orderRequestDto) {
		orderService.CreateOrder(orderRequestDto);
	}
}
