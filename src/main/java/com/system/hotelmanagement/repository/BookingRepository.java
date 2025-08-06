package com.system.hotelmanagement.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.system.hotelmanagement.model.BookingEntity;
import com.system.hotelmanagement.model.RoomEntity;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

	@Query("SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM BookingEntity  WHERE room = ?1 AND checkIn <= ?3 AND checkOut  >= ?2")
	public boolean isRoomReserved(RoomEntity roomId, LocalDate myCheckin, LocalDate myCheckout);

	public List<BookingEntity> findByCustomerId(Long id);
	
	@Query(" SELECT r FROM RoomEntity r WHERE NOT EXISTS (SELECT b FROM BookingEntity b WHERE b.room = r AND b.checkIn < :checkOut AND b.checkOut > :checkIn) ")
	List<RoomEntity> findAvailableRoomsByDate(@Param("checkIn") LocalDate checkIn, @Param("checkOut") LocalDate checkOut);

}

