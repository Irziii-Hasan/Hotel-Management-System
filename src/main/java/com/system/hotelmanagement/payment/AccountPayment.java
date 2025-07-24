package com.system.hotelmanagement.payment;

import org.springframework.stereotype.Service;

@Service
public class AccountPayment implements PaymentStrategy{

	@Override
	public String pay(double amount) {
		return "Your amount: "+amount+" has been withdraw ";
		
	}

	@Override
	public String getPaymentType() {
		return "account";
	}

}
