package com.system.hotelmanagement.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn  (name = "customer_id")
	private CustomerEntity customer;
	
	@ManyToOne
	@JoinColumn(name = "room_id")
	private RoomEntity room;
	
	@Column(nullable = false)
	private LocalDate checkIn;
	
	@Column (nullable = false)
	private LocalDate checkOut;
		
}
