package com.system.hotelmanagement.dto.booking;

import com.system.hotelmanagement.model.BookingEntity;

public class BookingDTOConvertor {

	public ViewBookingDTO entityToDto(BookingEntity bookRoom) {
		ViewBookingDTO dto = new ViewBookingDTO();
		dto.setId(bookRoom.getId());
		dto.setCustomer(bookRoom.getCustomer());
		dto.setRoom(bookRoom.getRoom());
		dto.setCheckIn(bookRoom.getCheckIn());
		dto.setCheckOut(bookRoom.getCheckOut());
		return dto;
	}
	
	public BookingEntity dtoToEntity(CreateBookingDTO dto) {
	
		return BookingEntity.builder()
		.room(dto.getRoom())
		.customer(dto.getCustomer())
		.checkIn(dto.getCheckIn())
		.checkOut(dto.getCheckOut())
		.build();
	}

}
