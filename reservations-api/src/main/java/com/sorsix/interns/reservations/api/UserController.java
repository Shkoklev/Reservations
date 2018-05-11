package com.sorsix.interns.reservations.api;


import com.sorsix.interns.reservations.model.User;
import com.sorsix.interns.reservations.model.requests.UserRequest;
import com.sorsix.interns.reservations.service.UserService;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody UserRequest userRequest) {
        return userService.saveUser(userRequest.firstName, userRequest.lastName,
                userRequest.email, userRequest.password,
                userRequest.birthDate, userRequest.place);
    }

    @GetMapping
    public List<User> getUsers() {
         return userService.getAllUsers();
    }

    @GetMapping("/loggedUser")
    public User getLoggedUser(Authentication authentication) {
        return (User)authentication.getPrincipal();
    }

}
