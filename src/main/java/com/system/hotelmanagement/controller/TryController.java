package com.system.hotelmanagement.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.system.hotelmanagement.dto.booking.BookingHistoryDTO;
import com.system.hotelmanagement.service.BookingService;
import com.system.hotelmanagement.service.LoggedInUserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TryController {
	
	@Autowired
	private final BookingService bookingService;
	private final LoggedInUserService loggedInUserService;
	
//	@GetMapping("/hotelmanagementsystem/customer/bookinghistory")
//	public List<BookingHistoryDTO> showBookingHistory(Principal principal) {
//	    Long customerId = loggedInUserService.getUsername(principal);
//	    return bookingService.showBookingHistory(customerId);
//	}

}
