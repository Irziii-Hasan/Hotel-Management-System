package com.system.hotelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.*;
import com.system.hotelmanagement.model.RoomEntity;
import com.system.hotelmanagement.service.RoomService;

@RestController
@RequestMapping ("hotelmanagementsystem/room")
public class RoomController {
	@Autowired
	private RoomService roomService;
	
	@PostMapping("/addRoom")
	public RoomEntity addRoom(@RequestBody RoomEntity roomEntity){
		return roomService.addRoom(roomEntity);
	}
	
	@GetMapping
	public List<RoomEntity> showRoom() {
		return roomService.showRoomsList();
	}
	
	@PatchMapping ("/{id}")
	public RoomEntity updateRoom(@PathVariable Long id, @RequestBody RoomEntity updateRoom) {
		return roomService.updateRoom(id, updateRoom);
	}
}
