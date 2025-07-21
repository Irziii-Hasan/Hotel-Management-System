package com.system.hotelmanagement.dto.room;

import lombok.Data;

@Data
public class ViewRoomDTO {
	private Long id;
	
	private Long occupancyCapacity;
	
	private double  ratePerNight;
	
	private Integer discountPercentage;
	
	private String description;
	
	private String availability;

}
