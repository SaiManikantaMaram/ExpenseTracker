package com.smani.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smani.dto.OrderRequest;
import com.smani.service.IOrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	private IOrderService ios;

	@PostMapping
	public String placeOrder(@RequestBody OrderRequest o) {
		return ios.placeOrder(o);
	}

}
