package com.adamkorzeniak.HRS.appartment.service;

import java.util.List;

import com.adamkorzeniak.HRS.appartment.model.Hotel;

public interface HotelService {

	Hotel addHotel(Hotel hotel);

	Hotel findHotel(Hotel hotel);

	List<Hotel> findAllHotels();

	List<Hotel> findHotels(String username);

	Hotel findHotel(Long id);
}