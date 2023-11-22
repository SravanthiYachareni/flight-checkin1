package com.sravs.flight.integration;

import com.sravs.flight.integration.dto.Reservation;
import com.sravs.flight.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {
    Reservation findReservation(Long id);
    Reservation updateReservation(ReservationUpdateRequest request);
}
