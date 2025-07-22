package com.system.hotelmanagement.dto.room;

import com.system.hotelmanagement.model.RoomEntity;

public class DTOConvertor {

	public ViewRoomDTO entityToDto(RoomEntity roomEntity) {
		ViewRoomDTO dto = new ViewRoomDTO();
		dto.setId(roomEntity.getId());
		dto.setOccupancyCapacity(roomEntity.getOccupancyCapacity());
		dto.setRatePerNight(roomEntity.getRatePerNight());
		dto.setAvailable(roomEntity.isAvailable());
		dto.setDescription(roomEntity.getDescription());
		dto.setDiscountPercentage(roomEntity.getDiscountPercentage());
		return dto;
	}
	
	public RoomEntity dtoToEntity(CreateRoomDTO createRoomDTO) {
		RoomEntity roomEntity = new RoomEntity();
		roomEntity.setAvailable(createRoomDTO.isAvailable());
		
		roomEntity.setRatePerNight(createRoomDTO.getRatePerNight());
		roomEntity.setOccupancyCapacity(createRoomDTO.getOccupancyCapacity());
		roomEntity.setDiscountPercentage(createRoomDTO.getDiscountPercentage());
		roomEntity.setDescription(createRoomDTO.getDescription());
		return roomEntity;
	}
}
