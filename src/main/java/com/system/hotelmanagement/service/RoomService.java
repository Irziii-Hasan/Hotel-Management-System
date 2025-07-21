package com.system.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.hotelmanagement.dto.room.CreateRoomDTO;
import com.system.hotelmanagement.dto.room.ViewRoomDTO;
import com.system.hotelmanagement.model.RoomEntity;
import com.system.hotelmanagement.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomService {

	@Autowired
	private final RoomRepository roomRepository;
	
	public ViewRoomDTO addRoom(CreateRoomDTO room) {
		RoomEntity roomEntity = dtoToEntity(room);
		RoomEntity savedRoom = roomRepository.save(roomEntity);
		return entityToDto(savedRoom);
	}
	
	public List<ViewRoomDTO> showRoomsList(){
		List<RoomEntity> roomList = roomRepository.findAll();
		return roomList.stream()
			.map(this :: entityToDto)
			.toList();
	}
	
	public ViewRoomDTO updateRoom(Long id, CreateRoomDTO dto) {
		RoomEntity existingStudent = roomRepository.findById(id)
				.orElseThrow(()-> new RuntimeException());
		if(dto.getOccupancyCapacity()!=null) {
			existingStudent.setOccupancyCapacity(dto.getOccupancyCapacity());
		}
		if(dto.getRatePerNight()!=0) {
			existingStudent.setRatePerNight(dto.getRatePerNight());
		}
		if(dto.getDiscountPercentage()!=null) {
			existingStudent.setDiscountPercentage(dto.getDiscountPercentage());
		}
		if(dto.getDescription()!=null) {
			existingStudent.setDescription(dto.getDescription());
		}
		if(dto.getAvailability()!=null) {
			existingStudent.setAvailability(dto.getAvailability());
		}
			
		RoomEntity updatedRoom =  roomRepository.save(existingStudent);
		return entityToDto(updatedRoom);
	}
	
	
	private ViewRoomDTO entityToDto(RoomEntity roomEntity) {
		ViewRoomDTO dto = new ViewRoomDTO();
		dto.setId(roomEntity.getId());
		dto.setOccupancyCapacity(roomEntity.getOccupancyCapacity());
		dto.setRatePerNight(roomEntity.getRatePerNight());
		dto.setAvailability(roomEntity.getAvailability());
		dto.setDescription(roomEntity.getDescription());
		dto.setDiscountPercentage(roomEntity.getDiscountPercentage());
		return dto;
	}
	
	private RoomEntity dtoToEntity(CreateRoomDTO createRoomDTO) {
		return RoomEntity.builder()
				.availability(createRoomDTO.getAvailability())
				.ratePerNight(createRoomDTO.getRatePerNight())
				.occupancyCapacity(createRoomDTO.getOccupancyCapacity())
				.discountPercentage(createRoomDTO.getDiscountPercentage())
				.description(createRoomDTO.getDescription())
				.build();
	}
}
