package com.sorsix.interns.reservations.api;


import com.sorsix.interns.reservations.model.User;
import com.sorsix.interns.reservations.model.UserRequest;
import com.sorsix.interns.reservations.service.UserService;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String hello() {
        return "Hello";
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody UserRequest userRequest) throws Exception {
        return userService.createUser(userRequest.firstName, userRequest.lastName, userRequest.email, userRequest.username,  userRequest.password, userRequest.birthDate, userRequest.place);
    }

}
