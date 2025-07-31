package com.system.hotelmanagement.payment;

import org.springframework.stereotype.Service;

import com.system.hotelmanagement.service.CustomerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountPayment implements PaymentStrategy{
	private final CustomerService customerService;

	@Override
	public boolean pay(double amount, Long customerId) {
		boolean isWithdraw =  customerService.withdrawBalance(customerId, amount);
		return isWithdraw;		
	}

	@Override
	public String getPaymentType() {
		return "account";
	}

}
