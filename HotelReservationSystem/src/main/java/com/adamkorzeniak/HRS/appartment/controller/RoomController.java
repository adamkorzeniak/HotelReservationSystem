package com.adamkorzeniak.HRS.appartment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.adamkorzeniak.HRS.appartment.model.Hotel;
import com.adamkorzeniak.HRS.appartment.model.Room;
import com.adamkorzeniak.HRS.appartment.service.HotelService;
import com.adamkorzeniak.HRS.appartment.service.RoomService;
import com.adamkorzeniak.HRS.exception.user.UnauthorizedUserException;
import com.adamkorzeniak.HRS.user.model.User;
import com.adamkorzeniak.HRS.user.service.UserService;

@RestController
@RequestMapping("/api")
public class RoomController {

	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/hotels/{hotelId}/rooms", method = RequestMethod.POST)
	public ResponseEntity<Room> createHotel(@RequestBody Room room, @PathVariable(value="hotelId") Long hotelId, UriComponentsBuilder ucBuilder) {
		
		Hotel hotel = hotelService.findHotel(hotelId);
		
		User user = userService.getUser(userService.getPrincipal());
		if (!user.getRole().isLandlord() && !user.isOwner(hotel)) {
			throw new UnauthorizedUserException();
		}
		
		room = roomService.addRoom(room, hotel);
		
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/hotel/" + hotelId + "/room/{id}").buildAndExpand(hotel.getId()).toUri());
        return new ResponseEntity<Room>(room, headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/hotels/{hotelId}/rooms", method = RequestMethod.GET)
	public ResponseEntity<List<Room>> findAllRooms(@PathVariable(value="hotelId") Long hotelId) {
		Hotel hotel = hotelService.findHotel(hotelId);
		List<Room> rooms = roomService.findRooms(hotel);
		
		return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/hotels/{hotelId}/rooms/{roomId}", method = RequestMethod.GET)
	public ResponseEntity<Room> createHotel(@PathVariable(value="hotelId") Long hotelId, @PathVariable(value="roomId") Long roomId) {
		
		Hotel hotel = hotelService.findHotel(hotelId);
		
		Room room = roomService.findRoom(roomId);
		
		if(!hotel.contains(room)) {
	        return new ResponseEntity<Room>(HttpStatus.OK);
		}
		
        return new ResponseEntity<Room>(room, HttpStatus.OK);
	}
}
