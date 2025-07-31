package com.system.hotelmanagement.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.system.hotelmanagement.dto.booking.BookingDTOConvertor;
import com.system.hotelmanagement.dto.booking.BookingHistoryDTO;
import com.system.hotelmanagement.dto.booking.CreateBookingDTO;
import com.system.hotelmanagement.dto.booking.ViewBookingCostDTO;
import com.system.hotelmanagement.model.BookingEntity;
import com.system.hotelmanagement.repository.BookingRepository;
import com.system.hotelmanagement.service.BookingService;
import com.system.hotelmanagement.service.LoggedInUserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping ("hotelmanagementsystem/customer")

public class BookingController {

    private final BookingRepository bookingRepository;
	@Autowired
	private final BookingService bookingService;
	private final LoggedInUserService loggedInUserService;	
	BookingDTOConvertor dto = new BookingDTOConvertor();

	
//	@PostMapping ("booknow/checkvalidation")
//	public String roomBookingValidationCheck(@RequestBody CreateBookingDTO bookingDTO) {
//		return bookingService.roomBookingValidationCheck(bookingDTO);
//	}
	
	@GetMapping("/room/booknow/{roomId}")
	public String getBookingForm(@PathVariable Long roomId, Principal principal, Model model) {
		Long customerId = loggedInUserService.getUsername(principal);
		model.addAttribute("customerId",customerId);
		model.addAttribute("roomId",roomId);
		return "bookingform";		
	}
	
	@GetMapping("/payment-details")
	@ResponseBody
	public ViewBookingCostDTO getPaymentSlip(@RequestParam Long roomId, @RequestParam LocalDate checkIn, @RequestParam  LocalDate checkOut) {
		boolean isDurationInValid = bookingService.isBookingDurationInValid(checkIn, checkOut);
		if (!isDurationInValid) {
			System.out.print(isDurationInValid);
			return bookingService.sendDetailsToForm(roomId, checkIn, checkOut);
		}
		System.out.print(isDurationInValid);

		return null;
	}

	@GetMapping("/bookinghistory")
	public String showBookingHistory(Principal principal, Model model) {
	    Long customerId = loggedInUserService.getUsername(principal);
	    List<BookingHistoryDTO> history =  bookingService.showBookingHistory(customerId);
	    model.addAttribute("bookings", history);
	    return "bookinghistory";
	}
	
	@PostMapping ("/room")
	@ResponseBody
	public String checkNow(@ModelAttribute CreateBookingDTO bookingDTO) {
		return bookingService.checkOut(bookingDTO);
		
	}
	
//	@GetMapping ("bookinghistory/{id}")
//	public List<BookingHistoryDTO> showBookingHistory(@PathVariable Long id){
//		return bookRoomService.showBookingHistory(id);
//	}
	
//	@PostMapping ("booknow/netamount")
//	public double getNetAmount(@RequestBody CreateBookingDTO bookingDTO) {
//		return bookingService.getPriceAfterDiscount(bookingDTO);
//	}
	

}
