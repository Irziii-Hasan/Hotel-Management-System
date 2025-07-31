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
	
	public boolean pay(String type, double amount, Long customerId) {
		for(PaymentStrategy st : strategy) {
			if(st.getPaymentType().equals(type)) {
				boolean success = st.pay(amount, customerId);
				System.out.println(amount +" customer id "+customerId);
				if(success) {
					System.out.println(success);
					return true;
					
				}
			}
		}
		return false;
	}
}
