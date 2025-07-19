package com.system.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.hotelmanagement.model.RoomEntity;

public interface RoomRepository extends JpaRepository<RoomEntity, Long> {

}
