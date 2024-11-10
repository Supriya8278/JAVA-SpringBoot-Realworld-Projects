package com.project.flightreservation.services;

import com.project.flightreservation.dtos.ReservationRequest;
import com.project.flightreservation.model.Reservation;

public interface ReservationService {
	
	Reservation bookFlight(ReservationRequest request);

}
