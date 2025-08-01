package com.system.hotelmanagement.dto.booking;

import java.time.LocalDate;

import com.system.hotelmanagement.model.CustomerEntity;
import com.system.hotelmanagement.model.RoomEntity;

import lombok.Data;

@Data
public class ViewBookingDTO {

	private Long id;
	
	private CustomerEntity customer;
	
	private RoomEntity room;
	
	private LocalDate checkIn;
	
	private LocalDate checkOut;
	
	private double netPrice;
	
	private String paymentMethod;

}
