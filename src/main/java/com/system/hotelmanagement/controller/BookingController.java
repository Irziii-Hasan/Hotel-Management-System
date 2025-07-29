package com.system.hotelmanagement.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.hotelmanagement.dto.booking.BookingHistoryDTO;
import com.system.hotelmanagement.dto.booking.CreateBookingDTO;
import com.system.hotelmanagement.service.BookingService;
import com.system.hotelmanagement.service.LoggedInUserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping ("hotelmanagementsystem/customer")

public class BookingController {
	@Autowired
	private final BookingService bookingService;
	private final LoggedInUserService loggedInUserService;	
	
	@PostMapping ("booknow/checkvalidation")
	public String roomBookingValidationCheck(@RequestBody CreateBookingDTO bookingDTO) {
		return bookingService.roomBookingValidationCheck(bookingDTO);
	}
	
	
	@GetMapping("/bookinghistory")
	public String showBookingHistory(Principal principal, Model model) {
	    Long customerId = loggedInUserService.getUsername(principal);
	    List<BookingHistoryDTO> history =  bookingService.showBookingHistory(customerId);
	    model.addAttribute("bookings", history);
	    return "bookinghistory";
	}
	
//	@GetMapping ("bookinghistory/{id}")
//	public List<BookingHistoryDTO> showBookingHistory(@PathVariable Long id){
//		return bookRoomService.showBookingHistory(id);
//	}
	
	@PostMapping ("booknow/netamount")
	public double getNetAmount(@RequestBody CreateBookingDTO bookingDTO) {
		return bookingService.getPriceAfterDiscount(bookingDTO);
	}
	

}
