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
import com.adamkorzeniak.HRS.appartment.service.HotelService;
import com.adamkorzeniak.HRS.exception.user.UnauthorizedUserException;
import com.adamkorzeniak.HRS.user.model.User;
import com.adamkorzeniak.HRS.user.service.UserService;

@RestController
@RequestMapping("/api")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/hotels", method = RequestMethod.POST)
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel, UriComponentsBuilder ucBuilder) {
		
		User user = userService.getUser(userService.getPrincipal());
		if (!user.getRole().isLandlord()) {
			throw new UnauthorizedUserException();
		}
		hotel = hotelService.addHotel(hotel);
		
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/hotel/{id}").buildAndExpand(hotel.getId()).toUri());
        return new ResponseEntity<Hotel>(hotel, headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/hotels", method = RequestMethod.GET)
	public ResponseEntity<List<Hotel>> findAllHotels() {
		List<Hotel> hotels = hotelService.findAllHotels();
		return new ResponseEntity<List<Hotel>>(hotels, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/hotels/{id}", method = RequestMethod.GET)
	public ResponseEntity<Hotel> findHotelById(@PathVariable(value="id") Long id) {
		Hotel hotel = hotelService.findHotel(id);
		return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/myhotels", method = RequestMethod.GET)
	public ResponseEntity<List<Hotel>> findMyHotels() {
		String username = userService.getPrincipal();
		List<Hotel> hotels = hotelService.findHotels(username);
		return new ResponseEntity<List<Hotel>>(hotels, HttpStatus.OK);
	}
}
