package com.project.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.flightreservation.dtos.ReservationRequest;
import com.project.flightreservation.model.Flight;
import com.project.flightreservation.model.Reservation;
import com.project.flightreservation.repos.FlightRepository;
import com.project.flightreservation.services.ReservationService;




@Controller
public class ReservationController {
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationService reservationService;
	
	@GetMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
	Flight flight= flightRepository.findById(flightId).get();
	modelMap.addAttribute("flight", flight);
	return "completeReservation";
	}
	
	@PostMapping("/completeReservation")
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation created successfully and reservation id is " + reservation.getId());
		return "reservationConfirmation";
	}
}

