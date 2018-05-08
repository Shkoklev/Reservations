package com.sorsix.interns.reservations.model.requests;

import com.sorsix.interns.reservations.model.Place;

import java.time.LocalDate;

public class UserRequest {

    public String firstName;
    public String lastName;
    public LocalDate birthDate;
    public String username;
    public String email;
    public String password;
    public Place place;

}
