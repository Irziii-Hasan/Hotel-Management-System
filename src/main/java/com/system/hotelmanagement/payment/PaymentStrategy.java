package com.system.hotelmanagement.payment;

public interface PaymentStrategy {

	public String pay(double amount);
	
	public String getPaymentType();
}
