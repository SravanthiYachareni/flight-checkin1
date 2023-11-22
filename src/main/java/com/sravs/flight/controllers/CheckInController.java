package com.sravs.flight.controllers;

import com.sravs.flight.integration.ReservationRestClient;
import com.sravs.flight.integration.dto.Reservation;
import com.sravs.flight.integration.dto.ReservationUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckInController {
    @Autowired
    ReservationRestClient restClient;

    @RequestMapping("/showStartCheckin")
    public String showStartCheckin() {
        return "startCheckIn";
    }

    @RequestMapping("/startCheckIn")
    public String startCheckIn(@RequestParam("reservationId") Long reservationId, ModelMap modelMap) {
        Reservation reservation = restClient.findReservation(reservationId);
        modelMap.addAttribute("reservation", reservation);
        return "displayReservationDetails";
    }

    @RequestMapping("/completeCheckIn")
    public String completeCheckIn(@RequestParam("reservationId") Long reservationId,
                                  @RequestParam("numberOfBags") int numberOfBags) {
        ReservationUpdateRequest request = new ReservationUpdateRequest();
        request.setId(reservationId);
        request.setCheckedIn(true);
        request.setNumberOfBags(numberOfBags);
        return "checkInConfirmation";
    }


}

