package com.system.hotelmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.hotelmanagement.dto.customer.CustomerDTOConvertor;
import com.system.hotelmanagement.dto.registration.RegistrationRequestDTO;
import com.system.hotelmanagement.model.CustomerEntity;
import com.system.hotelmanagement.model.UserEntity;
import com.system.hotelmanagement.repository.CustomerRepository;
import com.system.hotelmanagement.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RegistrationService {

	@Autowired
	private final CustomerRepository customerRepository;
	private final UserRepository userRepository;
	CustomerDTOConvertor customerDTOConvertor = new CustomerDTOConvertor();
	
//	@Transactional
	public String registration(RegistrationRequestDTO dto) {
		
//		Register customer
		CustomerEntity customer = customerDTOConvertor.dtoToEntity(dto);
		CustomerEntity savedCustomer = customerRepository.save(customer);
		
//		Register user
		UserEntity user = UserEntity.builder()
		.username(dto.getUsername())
		.password(dto.getPassword())
		.customer(savedCustomer)
		.role("CUSTOMER")
		.build();
		
		userRepository.save(user);

		
		
		
		return "success";
		
		
	}
	
	
}
