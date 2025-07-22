package com.system.hotelmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.system.hotelmanagement.model.RoomEntity;

public interface RoomRepository extends JpaRepository<RoomEntity, Long> {

	public List<RoomEntity> findByAvailable(boolean isAvailable);

}
