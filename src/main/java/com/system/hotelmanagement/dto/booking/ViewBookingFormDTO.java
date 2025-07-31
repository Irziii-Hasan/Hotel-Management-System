package com.system.hotelmanagement.dto.booking;

import com.system.hotelmanagement.model.RoomEntity;

import lombok.Data;

@Data
public class ViewBookingFormDTO {
	private RoomEntity room;
	private Double ratePerNight;
	private Integer discount;
	private double netCost;
}
