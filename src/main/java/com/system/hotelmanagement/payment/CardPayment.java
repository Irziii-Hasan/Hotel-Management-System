package com.system.hotelmanagement.payment;

import org.springframework.stereotype.Service;

@Service
public class CardPayment implements PaymentStrategy {

	@Override
	public boolean pay(double amount, Long customerId) {
		return true;
		
	}

	@Override
	public String getPaymentType() {
		return "card";
	}

}
