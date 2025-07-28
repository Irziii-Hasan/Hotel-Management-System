package com.system.hotelmanagement.dto.booking;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BookingHistoryDTO {

	private String customerName;

	private Long roomId;
	
	private LocalDate checkIn;
	
	private LocalDate checkOut;
	
	private double netPrice;

	private String paymentMethod;
	
}
