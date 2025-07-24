package com.system.hotelmanagement.dto.customer;


import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class CreateCustomerDTO {
		
	private String firstName;
	
	private String email;

	private String lastName;
	
	private Integer accountBalance;
	
}
