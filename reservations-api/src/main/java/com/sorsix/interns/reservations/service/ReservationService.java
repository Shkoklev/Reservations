package com.sorsix.interns.reservations.service;

import com.sorsix.interns.reservations.model.Reservation;
import com.sorsix.interns.reservations.model.User;
import com.sorsix.interns.reservations.model.requests.ReservationRequest;
import com.sorsix.interns.reservations.repository.CompanyRepository;
import com.sorsix.interns.reservations.repository.ReservationRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ReservationService {

    public final ReservationRepository reservationRepository;
    public final CompanyRepository companyRepository;

    public ReservationService(ReservationRepository repository, CompanyRepository companyRepository) {
        this.reservationRepository = repository;
        this.companyRepository = companyRepository;
    }

    public List<Reservation> findCompanyReservations(Long companyId){
        return reservationRepository.findReservationByCompanyId(companyId);
    }

    public ResponseEntity<Reservation> reserve(ReservationRequest reservation, User user){

        if(reservation.company.getCapacity()>countReservations(reservation.company.getId(),reservation)){
        LocalDate localDate = LocalDate.of(reservation.forDate.year, reservation.forDate.month, reservation.forDate.day);
        Reservation r = new Reservation(reservation.remark, reservation.personCount, localDate, reservation.company);
        r.setUser(user);
        return ResponseEntity.ok(reservationRepository.save(r));
        }
        else {
            return ResponseEntity.status(HttpStatus.LOCKED).build();
        }
    }

    public List<Reservation> findCompanyReservationsOnDate(Long companyId, String date){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-M-d");
        LocalDate localDate = LocalDate.parse(date,dtf);
        return reservationRepository.findByCompanyIdAndForDate(companyId, localDate);
    }

    public List<Reservation> findByUserId(Long userId) {
        return reservationRepository.findByUserId(userId);
    }

    public void deleteById(Long id){
        reservationRepository.deleteById(id);
    }

    public Integer countReservations(Long companyId, ReservationRequest reservation){
        List<Reservation> reservations = findCompanyReservations(companyId);
        return reservations.stream()
                            .filter(res -> res.getForDate()
                                    .isEqual(LocalDate.of(reservation.forDate.year,
                                                        reservation.forDate.month,
                                                        reservation.forDate.day)))
                            .mapToInt(it-> it.getPersonCount())
                            .sum();
    }

}
