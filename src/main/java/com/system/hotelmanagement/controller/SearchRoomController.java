package com.system.hotelmanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.system.hotelmanagement.dto.room.ViewRoomDTO;
import com.system.hotelmanagement.service.SearchRoomService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping ("hotelmanagementsystem/room")
public class SearchRoomController {
	
	private final SearchRoomService roomService;
	
	@GetMapping ("search/by-availability")
	public List<ViewRoomDTO> searchRoomByAvailable(@RequestParam("available") boolean isAvailable){
		return roomService.searchRoomByAvailability(isAvailable);
		
	}
	
	@GetMapping ("search/by-id")
	public ViewRoomDTO searchRoomById(@PathVariable Long id) {
		return roomService.searchRoomById(id);
	}
	
	
}
