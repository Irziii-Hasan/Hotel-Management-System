package com.system.hotelmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.system.hotelmanagement.dto.room.CreateRoomDTO;
import com.system.hotelmanagement.dto.room.ViewRoomDTO;
import com.system.hotelmanagement.model.RoomEntity;
import com.system.hotelmanagement.repository.RoomRepository;
import com.system.hotelmanagement.service.RoomService;


@ExtendWith (MockitoExtension.class)
public class RoomServiceTest {

	@Mock
	RoomRepository roomRepo;
	
	@InjectMocks
	RoomService roomService;
	
	
	
//	@Test
//	void addRoom() {
//		CreateRoomDTO room = new CreateRoomDTO();
//		room.setOccupancyCapacity(2L);
//		room.setAvailable(true);
//		room.setDescription("room for testing");
//		room.setDiscountPercentage(0);
//		room.setRatePerNight(100);
//		
//		mock(RoomRepository.class);
//		when(roomRepo.save(room)).thenReturn(room);
//		RoomEntity savedRoom = roomService.addRoom(room);
//		assertEquals(1,savedRoom.size());
//	}
//	
//	@Test
//	void showRoomList() {
//		RoomEntity room = new RoomEntity();
//		room.setOccupancyCapacity(2L);
//		room.setAvailable(true);
//		room.setDescription("room for testing");
//		room.setDiscountPercentage(0);
//		room.setRatePerNight(100);
//		room.setId(1L);
//		
//		mock(RoomRepository.class);
//		when(roomRepo.findAll()).thenReturn(Arrays.asList(room));
//		List<ViewRoomDTO> savedRoom = roomService.showRoomsList();
//		assertEquals(1,savedRoom.size());		
//	}
//	
	
	
//	@Test
//	void checkRoomCalls() {
//		RoomEntity room = new RoomEntity();
//		room.setOccupancyCapacity(2L);
//		room.setAvailable(true);
//		room.setDescription("room for testing");
//		room.setDiscountPercentage(0);
//		room.setRatePerNight(100);
//		room.setId(1L);
//		
//		mock(RoomRepository.class);
//		when(roomRepo.findAll()).thenReturn(Arrays.asList(room));
//		List<ViewRoomDTO> savedRoom = roomService.showRoomsList();
//		assertEquals(verify(1, savedRoom.roomRepository.findAll()));
//
//	
}
