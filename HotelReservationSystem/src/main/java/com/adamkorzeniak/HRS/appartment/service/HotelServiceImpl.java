package com.adamkorzeniak.HRS.appartment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adamkorzeniak.HRS.appartment.model.Hotel;
import com.adamkorzeniak.HRS.appartment.repository.HotelRepository;
import com.adamkorzeniak.HRS.exception.hotel.HotelAlreadyExistsException;
import com.adamkorzeniak.HRS.user.service.UserService;

@Service("hotelService")
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private UserService userService;

	@Override
	public Hotel addHotel(Hotel hotel) {
		Hotel savedHotel = findHotel(hotel);
		if (savedHotel != null) {
			throw new HotelAlreadyExistsException();
		}
		hotel.setOwner(userService.getUser(userService.getPrincipal()));
		return hotelRepository.save(hotel);
	}
	
	@Override
	public Hotel findHotel(Hotel hotel) {
		return hotelRepository.findByNameAndCity(hotel.getName(), hotel.getCity());
	}
	
	@Override
	public List<Hotel> findHotels(String username) {
		return hotelRepository.findByOwner_Username(username);
	}

	@Override
	public List<Hotel> findAllHotels() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel findHotel(Long id) {
		return hotelRepository.findOne(id);
	}

}
