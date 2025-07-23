package com.system.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.hotelmanagement.dto.room.CreateRoomDTO;
import com.system.hotelmanagement.dto.room.RoomDTOConvertor;
import com.system.hotelmanagement.dto.room.ViewRoomDTO;
import com.system.hotelmanagement.model.RoomEntity;
import com.system.hotelmanagement.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomService {

	@Autowired
	private final RoomRepository roomRepository;
	RoomDTOConvertor dto = new RoomDTOConvertor();
	
	public ViewRoomDTO addRoom(CreateRoomDTO room) {
		RoomEntity roomEntity = dto.dtoToEntity(room);
		RoomEntity savedRoom = roomRepository.save(roomEntity);
		return dto.entityToDto(savedRoom);
	}
	
	public List<ViewRoomDTO> showRoomsList(){
		List<RoomEntity> roomList = roomRepository.findAll();
		return roomList.stream()
			.map(rList->dto.entityToDto(rList))
			.toList();
	}
	
	public String deleteRoom(Long id){
		roomRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("No room found with id"+id));
		roomRepository.deleteById(id);
		return "Room successfully deleted.";
	}
	
	public ViewRoomDTO updateRoom(Long id, CreateRoomDTO room) {
		RoomEntity existingStudent = roomRepository.findById(id)
				.orElseThrow(()-> new RuntimeException());
		if(room.getOccupancyCapacity()!=null) {
			existingStudent.setOccupancyCapacity(room.getOccupancyCapacity());
		}
		if(room.getRatePerNight()!=0) {
			existingStudent.setRatePerNight(room.getRatePerNight());
		}
		if(room.getDiscountPercentage()!=null) {
			existingStudent.setDiscountPercentage(room.getDiscountPercentage());
		}
		if(room.getDescription()!=null) {
			existingStudent.setDescription(room.getDescription());
		}
		if(room.isAvailable()) {
			existingStudent.setAvailable(room.isAvailable());
		}
			
		RoomEntity updatedRoom =  roomRepository.save(existingStudent);
		return dto.entityToDto(updatedRoom);
	}
	
	
}
