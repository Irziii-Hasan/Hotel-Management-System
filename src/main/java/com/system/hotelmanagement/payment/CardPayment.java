package com.system.hotelmanagement.payment;

import org.springframework.stereotype.Service;

@Service
public class CardPayment implements PaymentStrategy {

	@Override
	public String pay(double amount) {
		return "Your amount: "+amount+" has been withdraw ";
	}

	@Override
	public String getPaymentType() {
		return "card";
	}

}
