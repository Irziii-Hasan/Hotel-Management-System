package com.system.hotelmanagement.dto.customer;

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
}
