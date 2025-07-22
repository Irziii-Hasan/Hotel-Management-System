package com.system.hotelmanagement.dto.room;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
public class ViewRoomDTO {
	private Long id;
	
	private Long occupancyCapacity;
	
	private double  ratePerNight;
	
	private Integer discountPercentage;
	
	private String description;
	
	@Getter
	@Setter
	private boolean available;

}
