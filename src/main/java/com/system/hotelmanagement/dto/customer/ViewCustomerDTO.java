package com.system.hotelmanagement.dto.customer;

import lombok.Data;

@Data
public class ViewCustomerDTO {

	private Long id;
	
	private String firstName;
	
	private String email;

	private String lastName;
	
	private Integer accountBalance;
	
}
