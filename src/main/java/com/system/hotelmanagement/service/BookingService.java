package com.system.hotelmanagement.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.hotelmanagement.dto.booking.BookingDTOConvertor;
import com.system.hotelmanagement.dto.booking.BookingHistoryDTO;
import com.system.hotelmanagement.dto.booking.BookingHistoryDTOConvertor;
import com.system.hotelmanagement.dto.booking.CreateBookingDTO;
import com.system.hotelmanagement.dto.booking.CreateBookingFormDTO;
import com.system.hotelmanagement.dto.booking.ViewBookingCostDTO;
import com.system.hotelmanagement.dto.booking.ViewBookingDTO;
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
	private final PaymentService paymentService;
	
	BookingDTOConvertor dto = new BookingDTOConvertor();
	ViewBookingCostDTO bookingCostDTO = new ViewBookingCostDTO();
	BookingHistoryDTOConvertor dtoHistory = new BookingHistoryDTOConvertor();

	
//	public String roomBookingValidationCheck(Long roomId, Long customerId) {
//		
//		customerRepo.findById(customerId)
//                .orElseThrow(() -> new RuntimeException("Customer not found"));
//		roomRepo.findById(roomId)
//                .orElseThrow(() -> new RuntimeException("Room not found"));
//		
//		return "ok";
//	}
	public ViewBookingCostDTO sendDetailsToForm(Long roomId,LocalDate checkIn, LocalDate checkOut) { 
		RoomEntity room = roomRepo.findById(roomId)
				.orElseThrow(()-> new RuntimeException("can't find room"));
		
		bookingCostDTO.setRatePerNight(room.getRatePerNight());
		bookingCostDTO.setDiscountPercentage(room.getDiscountPercentage());
		Long totalDays = calculateDurationNights(checkIn, checkOut);
		bookingCostDTO.setTotalNights(totalDays);
		double durationCost = calculateDurationCost(totalDays,room.getRatePerNight());
		double netCost = getPriceAfterDiscount(durationCost, room.getDiscountPercentage());
		bookingCostDTO.setNetCost(netCost);
//		System.out.println(netCost);
//		CustomerEntity customer = customerRepo.findById(customerId)
//				.orElseThrow(()-> new RuntimeException("can't find room"));
//		
		
		return bookingCostDTO ;
	}
	 
	public String checkOut(CreateBookingDTO bookingDTO) {
		BookingEntity bookingRoom = dto.dtoToEntity(bookingDTO);
		RoomEntity room = roomRepo.findById(bookingDTO.getRoomId())
				.orElseThrow(()-> new RuntimeException("Room not found"));
//		System.out.println(bookingDTO.getNetPrice());
		CustomerEntity customer = customerRepo.findById(bookingDTO.getCustomerId())
				.orElseThrow(()-> new RuntimeException("Room not found"));
		Long totalDays = calculateDurationNights(bookingDTO.getCheckIn(), bookingDTO.getCheckOut());
//		System.out.println(totalDays);
		double durationCost = calculateDurationCost(totalDays,room.getRatePerNight());
		double netCost = getPriceAfterDiscount(durationCost, room.getDiscountPercentage());
//		System.out.println(netCost);
		
		boolean isSuccess = paymentService.pay(bookingDTO.getPaymentMethod(), netCost, bookingDTO.getCustomerId());
		if(!isSuccess) {
			return "insufficient balance";
		}

		bookingRoom.setCustomer(customer);
		bookingRoom.setRoom(room);
		bookingRoom.setNetPrice(netCost);
		bookingRepo.save(bookingRoom);
		return "Room book successfully";
	}
	
	public boolean isBookingDurationInValid(LocalDate checkIn, LocalDate checkOut) {
		return bookingRepo.isRoomReserved(checkIn, checkOut);
	}
	
	public Long calculateDurationNights(LocalDate checkIn, LocalDate checkOut) {
		return ChronoUnit.DAYS.between(checkIn, checkOut);

	}
	public double calculateDurationCost(Long totalDays, double ratePerNight){
		return totalDays*ratePerNight;
	}
	
	
	public double getPriceAfterDiscount(double totalAmount, int discount) {
	    return totalAmount - ((discount / 100.0) * totalAmount);
	}
	
//	public double getCostPerNight(CreateBookingDTO bookRoomDto) {
//		BookingEntity bookRoom = dto.dtoToEntity(bookRoomDto);
//		RoomEntity room = bookRoom.getRoom();
//		return room.getRatePerNight();
//	}
	
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
	
	
//	public List<ViewBookingDTO> showBookingHistory(Long id) {
//		List<BookingEntity> bookings =  bookingRepo.findByCustomerId(id);
//		return bookings.stream()
//				.map(t-> dto.entityToDto(t))
//				.toList();
//		
//	}
	
	public List<BookingHistoryDTO> showBookingHistory(Long id){
		List<BookingEntity> bookingList =  bookingRepo.findByCustomerId(id);
		return bookingList
				.stream()
				.map(t-> dtoHistory.entityToDto(t))
				.toList();
	}
	

	
	
}
