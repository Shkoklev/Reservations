package com.sorsix.interns.reservations.model.requests;

import com.sorsix.interns.reservations.model.Company;
import com.sorsix.interns.reservations.model.User;

public class ReservationRequest {

    public String remark;
    public Integer personCount;
    public Company company;
    public DateRequest forDate;
}
