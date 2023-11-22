package com.sravs.flight.integration;

import com.sravs.flight.integration.dto.Reservation;
import com.sravs.flight.integration.dto.ReservationUpdateRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {
    @Override
    public Reservation findReservation(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        Reservation reservation = restTemplate.getForObject("http://localhost:8080/flight/reservations/" + id, Reservation.class);
        return reservation;
    }

    @Override
    public Reservation updateReservation(ReservationUpdateRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        Reservation reservation = restTemplate.postForObject("http://localhost:8080/flight/reservations/", request, Reservation.class);
        return reservation;
    }
}
