package com.system.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.hotelmanagement.payment.PaymentStrategy;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {

	@Autowired
	private final List<PaymentStrategy> strategy;
	
	public String pay(String type, double amount) {
		for(PaymentStrategy st : strategy) {
			if(st.getPaymentType().equals(type)) {
				return st.pay(amount);
			}
		}
		return "no payment method found";
	}
}
