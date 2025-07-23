package com.system.hotelmanagement.dto.bookingroom;

import com.system.hotelmanagement.model.BookingRoom;

public class BookRoomDTOConvertor {
	
	public ViewBookingDTO entityToDto(BookingRoom bookRoom) {
		ViewBookingDTO dto = new ViewBookingDTO();
		dto.setId(bookRoom.getId());
		dto.setCustomer(bookRoom.getCustomer());
		dto.setRoom(bookRoom.getRoom());
		dto.setCheckIn(bookRoom.getCheckIn());
		dto.setCheckOut(bookRoom.getCheckOut());
		return dto;
	}
	
	public BookingRoom dtoToEntity(CreateBookingDTO dto) {
		return BookingRoom.builder()
		.room(dto.getRoom())
		.customer(dto.getCustomer())
		.checkIn(dto.getCheckIn())
		.checkOut(dto.getCheckOut())
		.build();
	}

}
