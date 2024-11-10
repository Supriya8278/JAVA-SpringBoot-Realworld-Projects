package com.project.flightcheckin.integration;

import com.project.flightcheckin.integration.dto.Reservation;
import com.project.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

	public Reservation findReservation(Long id);
	public Reservation updateReservation(ReservationUpdateRequest request);
}
