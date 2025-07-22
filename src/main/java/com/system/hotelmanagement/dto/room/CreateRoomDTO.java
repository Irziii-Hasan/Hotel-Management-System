package com.system.hotelmanagement.dto.room;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateRoomDTO {

	
	private Long occupancyCapacity;
	
	private double  ratePerNight;
	
	private Integer discountPercentage;
	
	private String description;
	
	private boolean available;
}
