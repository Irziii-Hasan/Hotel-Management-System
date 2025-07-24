package com.system.hotelmanagement.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.hotelmanagement.dto.bookingroom.BookingDTOConvertor;
import com.system.hotelmanagement.dto.bookingroom.CreateBookingDTO;
import com.system.hotelmanagement.dto.bookingroom.ViewBookingDTO;
import com.system.hotelmanagement.model.BookingEntity;
import com.system.hotelmanagement.model.CustomerEntity;
import com.system.hotelmanagement.model.RoomEntity;
import com.system.hotelmanagement.repository.BookingRepository;
import com.system.hotelmanagement.repository.CustomerRepository;
import com.system.hotelmanagement.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingService {

	@Autowired
	private final BookingRepository bookingRepo;
	private final CustomerRepository customerRepo;
	private final RoomRepository roomRepo;
	BookingDTOConvertor dto = new BookingDTOConvertor();
	
	public String roomBookingValidationCheck(CreateBookingDTO bookingDTO) {
		BookingEntity bookingRoom = dto.dtoToEntity(bookingDTO);
		
		CustomerEntity customer = customerRepo.findById(bookingDTO.getCustomer().getId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
		RoomEntity room = roomRepo.findById(bookingDTO.getRoom().getId())
                .orElseThrow(() -> new RuntimeException("Room not found"));
		boolean isReserved = bookingRepo.isRoomReserved(bookingRoom.getCheckIn(), bookingRoom.getCheckOut());
		
		if(isReserved) {
			return "you cannot book room "+bookingRoom.getRoom().getId()
					+ "for date between "+bookingRoom.getCheckIn()
					+" to "+bookingRoom.getCheckOut();
		}
		
		bookingRepo.save(bookingRoom);
		return "Room book successfully";
	}
	
//	public ViewBookingDTO bookRoom(CreateBookingDTO bookingDTO) {
//		Booking bookingRoom = dto.dtoToEntity(bookingDTO);
//		bookingRepo.save(bookingRoom);
//		return dto.entityToDto(bookingRoom);
//	}
	
//	public String roomBookingValidationCheck(BookingEntity booking) {
//		
//		boolean isReserved = bookingRepo.isRoomReserved(booking.getCheckIn(), booking.getCheckOut());
//		
//		if(isReserved) {
//			return "you cannot book room "+booking.getRoom().getId()
//					+ "for date between "+booking.getCheckIn()
//					+" to "+booking.getCheckOut();
//		}
////		return "You can book this room";
//		bookingRepo.save(booking);
//		return "Room book successfully";
//	}
	
	
	public List<ViewBookingDTO> showBookingHistory(Long id) {
		List<BookingEntity> bookings =  bookingRepo.findByCustomerId(id);
		return bookings.stream()
				.map(t-> dto.entityToDto(t))
				.toList();
	}
	
	public double getPriceAfterDiscount(CreateBookingDTO bookRoomDto) {
		BookingEntity bookRoom = dto.dtoToEntity(bookRoomDto);
		RoomEntity room = bookRoom.getRoom();
		double amount = room.getRatePerNight();
		int discount = room.getDiscountPercentage();

		return ((discount / 100)*amount)-amount;
	}
	
	public double getPrice(CreateBookingDTO bookRoomDto) {
		BookingEntity bookRoom = dto.dtoToEntity(bookRoomDto);
		RoomEntity room = bookRoom.getRoom();
		return room.getRatePerNight();
		
	}
	
}
