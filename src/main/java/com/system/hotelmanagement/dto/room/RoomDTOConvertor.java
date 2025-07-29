package com.system.hotelmanagement.dto.room;

import com.system.hotelmanagement.model.RoomEntity;

public class RoomDTOConvertor {

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
		return RoomEntity.builder()
		.available(createRoomDTO.isAvailable())
		.ratePerNight(createRoomDTO.getRatePerNight())
		.occupancyCapacity(createRoomDTO.getOccupancyCapacity())
		.discountPercentage(createRoomDTO.getDiscountPercentage())
		.description(createRoomDTO.getDescription())
		.build();
	}
	
	public ViewRoomByCustomerDTO customerRoomEntityToDto(RoomEntity roomEntity) {
		ViewRoomByCustomerDTO dto = new ViewRoomByCustomerDTO();
		dto.setId(roomEntity.getId());
		dto.setOccupancyCapacity(roomEntity.getOccupancyCapacity());
		dto.setRatePerNight(roomEntity.getRatePerNight());
		dto.setDescription(roomEntity.getDescription());
		dto.setDiscountPercentage(roomEntity.getDiscountPercentage());
		return dto;
	}
	
//	public RoomDataDTO entityToDtoForRoomHistory(RoomEntity roomEntity) {
//		RoomDataDTO dto = new RoomDataDTO();
//		dto.setId(roomEntity.getId());
//		dto.setOccupancyCapacity(roomEntity.getOccupancyCapacity());
//		dto.setDescription(roomEntity.getDescription());
//		return dto;
//	}
}
