package com.sorsix.interns.reservations.api;

import com.sorsix.interns.reservations.model.Reservation;
import com.sorsix.interns.reservations.model.User;
import com.sorsix.interns.reservations.model.requests.DateRequest;
import com.sorsix.interns.reservations.model.requests.ReservationRequest;
import com.sorsix.interns.reservations.service.ReservationService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api/reserve")
public class ReserveController {

    private final ReservationService service;

    public ReserveController(ReservationService service) {
        this.service = service;
    }


    @PostMapping
    public Reservation reserve(@RequestBody ReservationRequest reservation, Authentication authentication){
        return service.reserve(reservation, (User)authentication.getPrincipal());
    }

    @GetMapping("/{companyId}")
    public List<Reservation> findCompanyReservations(@PathVariable Long companyId){
        return service.findCompanyReservations(companyId);
    }

    @GetMapping("/{companyId}/{date}")
    public List<Reservation> findCompanyReservationsOnDate(@PathVariable Long companyId, @PathVariable String date){
        return service.findCompanyReservationsOnDate(companyId,date);
    }

}
