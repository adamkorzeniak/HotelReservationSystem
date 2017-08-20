package com.adamkorzeniak.HRS.appartment.service;

import java.util.List;

import com.adamkorzeniak.HRS.appartment.model.Hotel;
import com.adamkorzeniak.HRS.appartment.model.Room;

public interface RoomService {

	List<Room> findRooms(Hotel hotel);

	Room findRoom(Long roomId);

	Room addRoom(Room room, Hotel hotel);

}
