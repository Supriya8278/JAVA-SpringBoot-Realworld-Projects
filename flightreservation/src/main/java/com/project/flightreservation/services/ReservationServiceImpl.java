package com.project.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.flightreservation.dtos.ReservationRequest;
import com.project.flightreservation.model.Flight;
import com.project.flightreservation.model.Passenger;
import com.project.flightreservation.model.Reservation;
import com.project.flightreservation.repos.FlightRepository;
import com.project.flightreservation.repos.PassengerRepository;
import com.project.flightreservation.repos.ReservationRepository;


@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		Flight flight = flightRepository.findById(request.getFlightId()).get();
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassangerFirstName());
		passenger.setLastName(request.getPassangerLastName());
		passenger.setEmail(request.getPassangerEmail());;
		passenger.setPhone(request.getPassangerPhone());
		
		Passenger savedPassenger = passengerRepository.save(passenger);
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		Reservation savedReservation = reservationRepository.save(reservation);
		
		return savedReservation;
	}

}
