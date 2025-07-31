package com.system.hotelmanagement.dto.booking;

import java.time.LocalDate;

import com.system.hotelmanagement.model.RoomEntity;

import lombok.Data;

@Data
public class CreateBookingFormDTO {
	private RoomEntity room;
	private Double ratePerNight;
	private Integer discount;
	private double netCost;
	LocalDate checkIn;
	LocalDate checkOut;

}
