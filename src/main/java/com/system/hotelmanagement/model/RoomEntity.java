package com.system.hotelmanagement.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class RoomEntity {

	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Long occupancyCapacity;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal  ratePerNight;
	
	@Column
	private Integer discountPercentage;
	
	@Column
	private String description;
	
	@Column 
	private String availability;
	
}
