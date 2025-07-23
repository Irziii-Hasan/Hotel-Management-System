package com.system.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.hotelmanagement.model.BookingRoom;

@Repository
public interface BoookingRoomRepository extends JpaRepository<BookingRoom, Long> {

}
