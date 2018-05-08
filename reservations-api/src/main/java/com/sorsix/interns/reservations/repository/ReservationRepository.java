package com.sorsix.interns.reservations.repository;

import com.sorsix.interns.reservations.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Long countByCompany_Name(String name);
    List<Reservation> findByUser_Username(String username);
}
