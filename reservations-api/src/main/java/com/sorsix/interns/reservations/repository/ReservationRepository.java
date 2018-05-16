package com.sorsix.interns.reservations.repository;

import com.sorsix.interns.reservations.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
      List<Reservation> findByCompany_Id(Long companyId);
      List<Reservation> findByCompany_IdAndForDate(Long companyId, LocalDate date);
      List<Reservation> findByUser_Id(Long userId);
}
