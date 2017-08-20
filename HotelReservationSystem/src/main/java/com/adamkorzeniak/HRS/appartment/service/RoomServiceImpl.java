package com.adamkorzeniak.HRS.appartment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adamkorzeniak.HRS.appartment.model.Hotel;
import com.adamkorzeniak.HRS.appartment.model.Room;
import com.adamkorzeniak.HRS.appartment.repository.RoomRepository;

@Service("roomService")
public class RoomServiceImpl implements RoomService{
	
	@Autowired
	RoomRepository roomRepository;

	@Override
	public Room addRoom(Room room, Hotel hotel) {
		hotel.addRoom(room);
		room.setHotel(hotel);
		return roomRepository.save(room);
	}

	@Override
	public List<Room> findRooms(Hotel hotel) {
		return roomRepository.findRoomsByHotel(hotel);
	}

	@Override
	public Room findRoom(Long roomId) {
		return roomRepository.findOne(roomId);
	}

}
