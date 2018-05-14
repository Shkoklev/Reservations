package com.sorsix.interns.reservations.api;

import com.sorsix.interns.reservations.model.Reservation;
import com.sorsix.interns.reservations.model.User;
import com.sorsix.interns.reservations.model.requests.ReservationRequest;
import com.sorsix.interns.reservations.repository.ReservationRepository;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@RequestMapping("/api/reserve")
public class ReserveController {

    private final ReservationRepository repository;

    public ReserveController(ReservationRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Reservation reserve(@RequestBody ReservationRequest reservation, Authentication authentication){
        LocalDate localDate = LocalDate.of(reservation.forDate.year, reservation.forDate.month, reservation.forDate.day);
        Reservation r = new Reservation(reservation.remark, reservation.personCount, localDate, reservation.company);
        r.setUser((User)authentication.getPrincipal());
        return repository.save(r);
    }

}
