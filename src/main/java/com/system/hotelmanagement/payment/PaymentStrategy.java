package com.system.hotelmanagement.payment;

public interface PaymentStrategy {

	public boolean pay(double amount, Long customerId);
	
	public String getPaymentType();
}
