package com.system.hotelmanagement.dto.booking;

import lombok.Data;

@Data
public class ViewBookingCostDTO {
	
	private double ratePerNight;
	private Integer discountPercentage;
	private Long totalNights;
	private double netCost;
}
