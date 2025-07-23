package com.system.hotelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.hotelmanagement.dto.customer.CreateCustomerDTO;
import com.system.hotelmanagement.dto.customer.ViewCustomerDTO;
import com.system.hotelmanagement.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping ("hotelmanagementsystem")
public class CustomerController {
	
	@Autowired
	private final CustomerService customerService;
	
	@PostMapping ("customer/addcustomer")
	public ViewCustomerDTO AddCustomer(CreateCustomerDTO customer) {
		return customerService.addCustomer(customer);
	}
	
	@GetMapping ("customer")
	public List<ViewCustomerDTO> showCustomer(CreateCustomerDTO customer){
		return customerService.showCustomer();
	}
}
