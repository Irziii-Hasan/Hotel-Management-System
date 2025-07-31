package com.system.hotelmanagement.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.hotelmanagement.dto.room.RoomDTOConvertor;
import com.system.hotelmanagement.dto.room.ViewRoomByCustomerDTO;
import com.system.hotelmanagement.dto.room.ViewRoomDTO;
import com.system.hotelmanagement.model.RoomEntity;
import com.system.hotelmanagement.repository.BookingRepository;
import com.system.hotelmanagement.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchRoomService {

	@Autowired
	private final RoomRepository roomRepository;
	private final BookingRepository bookingRepository;
	RoomDTOConvertor dto = new RoomDTOConvertor();

	
	public List<ViewRoomByCustomerDTO> searchRoomByAvailability() {
		List<RoomEntity> searchRoom =  roomRepository.findAvailableRooms();
		return searchRoom.stream()
				.map(rList->dto.customerRoomEntityToDto(rList))
				.toList();
	}
	
	
	public ViewRoomDTO searchRoomById(Long id) {
		RoomEntity room = roomRepository.findById(id)
			.orElseThrow(()-> new RuntimeException("Room not found with id: "));
		return dto.entityToDto(room);
	}
	
	public List<ViewRoomByCustomerDTO> searchAvailableRoomByDuration (LocalDate checkin, LocalDate checkout) {
		List<RoomEntity> availableRoomsFromBooking =  bookingRepository.findAvailableRoomsByDate(checkin, checkout);
		return availableRoomsFromBooking.stream()
				.map(rList->dto.customerRoomEntityToDto(rList))
				.toList();
	}
	
}
