package com.system.hotelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.hotelmanagement.dto.bookingroom.CreateBookingDTO;
import com.system.hotelmanagement.dto.bookingroom.ViewBookingDTO;
import com.system.hotelmanagement.model.BookingEntity;
import com.system.hotelmanagement.service.BookingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping ("hotelmanagementsystem/customer")

public class BookingController {
	@Autowired
	private final BookingService bookRoomService;
	
	
	@PostMapping ("booknow/checkvalidation")
	public String roomBookingValidationCheck(@RequestBody CreateBookingDTO bookingDTO) {
		return bookRoomService.roomBookingValidationCheck(bookingDTO);
	}
	
	
	
	@GetMapping ("bookinghistory/{id}")
	public List<ViewBookingDTO> showBookingHistory(@PathVariable Long id){
		return bookRoomService.showBookingHistory(id);
	}
	
	@PostMapping ("booknow/netamount")
	public double getNetAmount(@RequestBody CreateBookingDTO bookingDTO) {
		return bookRoomService.getPriceAfterDiscount(bookingDTO);
	}
	
}
