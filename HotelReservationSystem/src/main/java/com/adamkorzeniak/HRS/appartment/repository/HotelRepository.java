package com.adamkorzeniak.HRS.appartment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adamkorzeniak.HRS.appartment.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

	Hotel findByNameAndCity(String name, String city);

	List<Hotel> findByOwner_Username(String username);

}
