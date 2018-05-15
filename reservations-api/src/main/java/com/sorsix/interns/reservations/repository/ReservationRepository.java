package com.sorsix.interns.reservations.repository;

import com.sorsix.interns.reservations.model.Reservation;
import com.sorsix.interns.reservations.model.requests.DateRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
      List<Reservation> findReservationByCompanyId(Long companyId);
      List<Reservation> findByCompanyIdAndForDate (Long companyId, LocalDate date);
}
