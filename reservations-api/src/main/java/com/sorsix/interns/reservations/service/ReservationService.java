package com.sorsix.interns.reservations.service;

import com.sorsix.interns.reservations.model.Reservation;
import com.sorsix.interns.reservations.model.User;
import com.sorsix.interns.reservations.model.requests.ReservationRequest;
import com.sorsix.interns.reservations.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ReservationService {

    public final ReservationRepository repository;

    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    public List<Reservation> findCompanyReservations(Long companyId){
        return repository.findReservationByCompanyId(companyId);
    }

    public Reservation reserve(ReservationRequest reservation, User user){
        LocalDate localDate = LocalDate.of(reservation.forDate.year, reservation.forDate.month, reservation.forDate.day);
        Reservation r = new Reservation(reservation.remark, reservation.personCount, localDate, reservation.company);
        r.setUser(user);
        return repository.save(r);
    }

    public List<Reservation> findCompanyReservationsOnDate(Long companyId, String date){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-M-d");
        LocalDate localDate = LocalDate.parse(date,dtf);
        return repository.findByCompanyIdAndForDate(companyId, localDate);
    }

}
