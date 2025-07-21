package com.system.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.hotelmanagement.model.RoomEntity;
import com.system.hotelmanagement.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomService {

	@Autowired
	private final RoomRepository roomRepository;
	
	public RoomEntity addRoom(RoomEntity room) {
		return roomRepository.save(room);
	}
	
	public List<RoomEntity> showRoomsList(){
		return roomRepository.findAll();
	}
	
	public RoomEntity updateRoom(Long id, RoomEntity updatedRoom) {
		RoomEntity existingStudent = roomRepository.findById(id)
				.orElseThrow(()-> new RuntimeException());
		if(updatedRoom.getOccupancyCapacity()!=null) {
			existingStudent.setOccupancyCapacity(updatedRoom.getOccupancyCapacity());
		}
		if(updatedRoom.getRatePerNight()!=0) {
			existingStudent.setRatePerNight(updatedRoom.getRatePerNight());
		}
		if(updatedRoom.getDiscountPercentage()!=null) {
			existingStudent.setDiscountPercentage(updatedRoom.getDiscountPercentage());
		}
		if(updatedRoom.getDescription()!=null) {
			existingStudent.setDescription(updatedRoom.getDescription());
		}
		if(updatedRoom.getAvailability()!=null) {
			existingStudent.setAvailability(updatedRoom.getAvailability());
		}
			
		return roomRepository.save(existingStudent);
	}
	
}
