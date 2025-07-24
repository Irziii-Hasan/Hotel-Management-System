package com.system.hotelmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.system.hotelmanagement.service.PaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping ("hotelmanagementsystem/customer/payment")
public class PaymentController {
	@Autowired
	private final PaymentService paymentService;
	
	@PostMapping
	public String getPayment(@RequestParam String type, @RequestParam double amount) {
		return paymentService.pay(type, amount);
	}
	

}
