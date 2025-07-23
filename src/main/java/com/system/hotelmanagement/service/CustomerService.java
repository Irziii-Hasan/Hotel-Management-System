package com.system.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.hotelmanagement.dto.customer.CreateCustomerDTO;
import com.system.hotelmanagement.dto.customer.CustomerDTOConvertor;
import com.system.hotelmanagement.dto.customer.ViewCustomerDTO;
import com.system.hotelmanagement.model.CustomerEntity;
import com.system.hotelmanagement.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

	@Autowired
	private final CustomerRepository customerRepository;
	CustomerDTOConvertor dto = new CustomerDTOConvertor();
	
	public ViewCustomerDTO addCustomer(CreateCustomerDTO customerDto) {
		CustomerEntity customer = dto.dtoToEntity(customerDto);
		customerRepository.save(customer);
		return dto.entityToDto(customer);
	}
	
	public List<ViewCustomerDTO> showCustomer(){
		List<CustomerEntity> customer = customerRepository.findAll();
		return customer.stream()
		.map(cList-> dto.entityToDto(cList))
		.toList();
	}
	
}
