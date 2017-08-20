package com.adamkorzeniak.HRS.appartment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adamkorzeniak.HRS.appartment.model.Hotel;
import com.adamkorzeniak.HRS.appartment.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

	List<Room> findRoomsByHotel(Hotel hotel);

}
