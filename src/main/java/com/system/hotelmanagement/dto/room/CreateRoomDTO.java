package com.system.hotelmanagement.dto.room;

import lombok.Data;

@Data
public class CreateRoomDTO {

	
	private Long occupancyCapacity;
	
	private double  ratePerNight;
	
	private Integer discountPercentage;
	
	private String description;
	
	private String availability;
}
