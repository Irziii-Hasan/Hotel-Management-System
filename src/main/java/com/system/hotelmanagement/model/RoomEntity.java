package com.system.hotelmanagement.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomEntity {

	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Long occupancyCapacity;
	
	@Column
	private double  ratePerNight;
	
	@Column
	private Integer discountPercentage;
	
	@Column
	private String description;
	
	@Column
	private boolean available;
		
	
	@OneToMany(mappedBy = "room", cascade = CascadeType.REMOVE) 
    private List<BookingEntity> bookings;
}
