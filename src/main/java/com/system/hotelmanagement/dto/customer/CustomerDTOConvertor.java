package com.system.hotelmanagement.dto.customer;

import com.system.hotelmanagement.dto.registration.RegistrationRequestDTO;
import com.system.hotelmanagement.model.CustomerEntity;

public class CustomerDTOConvertor {

	public ViewCustomerDTO entityToDto(CustomerEntity customer) {
		ViewCustomerDTO dto = new ViewCustomerDTO();
		dto.setId(customer.getId());
		dto.setFirstName(customer.getFirstName());
		dto.setLastName(customer.getLastName());
		dto.setEmail(dto.getEmail());
		return dto;
	}
	
	public CustomerEntity dtoToEntity(CreateCustomerDTO dto) {
		return CustomerEntity.builder()
		.firstName(dto.getFirstName())
		.lastName(dto.getLastName())
		.email(dto.getEmail())
		.build();
	}
	
	public CustomerDataDTO entityToDtoForName(CustomerEntity customer) {
		CustomerDataDTO dto = new CustomerDataDTO();
		dto.setFullName(customer.getFirstName()+" "+customer.getLastName());
		return dto;
	}

	public CustomerEntity dtoToEntity(RegistrationRequestDTO dto) {
		return CustomerEntity.builder()
				.firstName(dto.getFirstName())
				.lastName(dto.getLastName())
				.email(dto.getEmail())
				.build();
	}
}
