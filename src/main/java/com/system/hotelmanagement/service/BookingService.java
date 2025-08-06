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
import com.system.hotelmanagement.dto.booking.ViewBookingCostDTO;
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


	public ViewBookingCostDTO getPaymentSlip(Long roomId, LocalDate checkIn, LocalDate checkOut) {
		boolean isDurationInValid = isBookingDurationInValid(roomId, checkIn, checkOut);
		boolean isNotNegative = isDurationNotNegative(checkIn,checkOut);
		if (!isDurationInValid && (!isNotNegative) ) {
			return sendDetailsToForm(roomId, checkIn, checkOut);
		} else {
			return null;
		}
	}
	
	
	public boolean isDurationNotNegative(LocalDate checkIn, LocalDate checkOut) {
		if (checkOut.isBefore(checkIn)) {
			return 	true;	
		}else {
			return false;
		}
	}
	
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
		return bookingCostDTO ;
	}
	
	 
	public String checkOut(CreateBookingDTO bookingDTO) {
		BookingEntity bookingRoom = dto.dtoToEntity(bookingDTO);
		RoomEntity room = roomRepo.findById(bookingDTO.getRoomId())
				.orElseThrow(()-> new RuntimeException("Room not found"));
		CustomerEntity customer = customerRepo.findById(bookingDTO.getCustomerId())
				.orElseThrow(()-> new RuntimeException("Room not found"));
		
		Long totalDays = calculateDurationNights(bookingDTO.getCheckIn(), bookingDTO.getCheckOut());
		double durationCost = calculateDurationCost(totalDays,room.getRatePerNight());
		double netCost = getPriceAfterDiscount(durationCost, room.getDiscountPercentage());
		
		boolean isSuccess = paymentService.pay(bookingDTO.getPaymentMethod(), netCost, bookingDTO.getCustomerId());
		if(!isSuccess) {
			return "insufficient balance";
		}

		bookingRoom.setCustomer(customer);
		bookingRoom.setRoom(room);
		bookingRoom.setNetPrice(netCost);
		bookingRepo.save(bookingRoom);
		return "Room has been booked successfully";
	}
	
	
	public boolean isBookingDurationInValid(Long roomId, LocalDate checkIn, LocalDate checkOut) {
		RoomEntity room = roomRepo.findById(roomId)
				.orElseThrow(()-> new RuntimeException("Room not found"));
		return bookingRepo.isRoomReserved(room, checkIn, checkOut);
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
	
	
	public List<BookingHistoryDTO> showBookingHistory(Long id){
		List<BookingEntity> bookingList =  bookingRepo.findByCustomerId(id);
		return bookingList
				.stream()
				.map(t-> dtoHistory.entityToDto(t))
				.toList();
	}	
}
