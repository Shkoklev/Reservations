package com.sorsix.interns.reservations.repository;

import com.sorsix.interns.reservations.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
      List<Reservation> findReservationByCompanyId(Long companyId);
      List<Reservation> findByCompanyIdAndForDate (Long companyId, LocalDate date);
      List<Reservation> findByUser_FirstName(String userFirstName);

}
