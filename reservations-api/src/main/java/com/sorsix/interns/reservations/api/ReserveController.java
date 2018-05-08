package com.sorsix.interns.reservations.api;

import com.sorsix.interns.reservations.model.Reservation;
import com.sorsix.interns.reservations.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/reserve")
public class ReserveController {

    private final ReservationRepository repository;

    public ReserveController(ReservationRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<Reservation>> reservationsForUserID(@PathVariable String username, Principal principal) {
        if (principal.getName() == username) {
            return ResponseEntity.ok(repository.findByUser_Username(username));
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

    }

    @PostMapping
    public Reservation reserve(@RequestBody Reservation reservation) {
        return repository.save(reservation);
    }
}
