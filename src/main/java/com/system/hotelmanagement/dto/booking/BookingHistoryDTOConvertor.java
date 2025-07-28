package com.system.hotelmanagement.dto.booking;

import com.system.hotelmanagement.model.BookingEntity;

public class BookingHistoryDTOConvertor {

	public BookingHistoryDTO entityToDto(BookingEntity bookRoom) {
		BookingHistoryDTO dto = new BookingHistoryDTO();
		dto.setRoomId(bookRoom.getRoom().getId());
		dto.setCustomerName(bookRoom.getCustomer().getFirstName() +" " + bookRoom.getCustomer().getLastName());
		dto.setCheckIn(bookRoom.getCheckIn());
		dto.setCheckOut(bookRoom.getCheckOut());
		return dto;
	}
}
