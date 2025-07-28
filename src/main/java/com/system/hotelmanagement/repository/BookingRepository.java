package com.system.hotelmanagement.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.system.hotelmanagement.model.BookingEntity;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

	@Query("SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM BookingEntity  WHERE checkIn <= ?2 AND checkOut  >= ?1")
	public boolean isRoomReserved(LocalDate myCheckin, LocalDate myCheckout);

	public List<BookingEntity> findByCustomerId(Long id);
	
	@Query("SELECT b FROM BookingEntity b JOIN b.room r WHERE b.checkIn >= :checkIn AND b.checkOut <= :checkOut AND r.available = true")
	List<BookingEntity> getAvailableRoomsByDate(@Param("checkIn") LocalDate checkIn, @Param("checkOut") LocalDate checkOut);	

}

