package com.system.hotelmanagement.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.system.hotelmanagement.dto.room.ViewRoomByCustomerDTO;
import com.system.hotelmanagement.dto.room.ViewRoomDTO;
import com.system.hotelmanagement.service.SearchRoomService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping ("hotelmanagementsystem/customer/room")
public class SearchRoomController {
	
	private final SearchRoomService roomService;
	
	@GetMapping
	public String  searchRoomByAvailable(Model model){
		List<ViewRoomByCustomerDTO> rooms =  roomService.searchRoomByAvailability();
		model.addAttribute("rooms",rooms);
		return "roomlist";
	}
	
	@GetMapping ("/search")
	public String  searchAvailableRoomByDuration(@RequestParam("checkIn") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkIn,
		    @RequestParam("checkOut") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOut,
		    Model model) {
		List<ViewRoomByCustomerDTO> availableRoomsFromBooking =  roomService.searchAvailableRoomByDuration(checkIn, checkOut);
	    model.addAttribute("rooms", availableRoomsFromBooking);

		return "roomlist";
	}
	
//	@GetMapping ("search/by-id")
//	public ViewRoomDTO searchRoomById(@PathVariable Long id) {
//		return roomService.searchRoomById(id);
//	}
//	
	
}
