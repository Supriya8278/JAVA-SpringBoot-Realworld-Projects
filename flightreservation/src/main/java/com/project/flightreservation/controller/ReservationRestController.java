package com.project.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.flightreservation.dto.ReservationUpdateRequest;
import com.project.flightreservation.model.Reservation;
import com.project.flightreservation.repos.ReservationRepository;

@RestController

public class ReservationRestController {

	@Autowired
	ReservationRepository reservationRepository;
	
	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
	    return reservationRepository.findById(id).orElseThrow(null);
	}
	
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
	    Long id = request.getId();
	    Reservation reservation = reservationRepository.findById(id).orElseThrow(null);
	    reservation.setNumberOfBags(request.getNumberOfBags());
	    reservation.setCheckedIn(request.getCheckedIn());
	    return reservationRepository.save(reservation);
	}
}
