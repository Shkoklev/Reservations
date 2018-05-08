package com.sorsix.interns.reservations.Exception;


public class UserExistException extends Exception {

    public UserExistException() { }

    UserExistException(String message){
        super(message);
    }

}
