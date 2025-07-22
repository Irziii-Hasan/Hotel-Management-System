package com.system.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.hotelmanagement.dto.room.DTOConvertor;
import com.system.hotelmanagement.dto.room.ViewRoomDTO;
import com.system.hotelmanagement.model.RoomEntity;
import com.system.hotelmanagement.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchRoomService {

	@Autowired
	private RoomRepository roomRepository;
	DTOConvertor dto = new DTOConvertor();

	
	public List<ViewRoomDTO> searchRoomByAvailability(boolean isAvailable) {
		List<RoomEntity> searchRoom =  roomRepository.findByAvailable(isAvailable);
		return searchRoom.stream()
				.map(rList->dto.entityToDto(rList))
				.toList();
		
	}
	
	public ViewRoomDTO searchRoomById(Long id) {
		RoomEntity room = roomRepository.findById(id)
			.orElseThrow(()-> new RuntimeException("Room not found with id: "));
		return dto.entityToDto(room);
	}
	
}
