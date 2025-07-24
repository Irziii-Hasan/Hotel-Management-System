package com.system.hotelmanagement.dto.bookingroom;

import org.springframework.beans.factory.annotation.Autowired;

import com.system.hotelmanagement.model.BookingEntity;
import com.system.hotelmanagement.model.CustomerEntity;
import com.system.hotelmanagement.model.RoomEntity;
import com.system.hotelmanagement.repository.CustomerRepository;
import com.system.hotelmanagement.repository.RoomRepository;

public class BookingDTOConvertor {
	
	@Autowired
	private CustomerRepository customerRepo;
	private RoomRepository roomRepo;
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
