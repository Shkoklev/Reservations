package com.sorsix.interns.reservations.api;


import com.sorsix.interns.reservations.model.User;
import com.sorsix.interns.reservations.service.UserService;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) throws Exception {
        return userService.createUser(user.getName(),user.getSurname(),user.getUsername(),
                        user.getEmail(),user.getAge(),user.getPassword(), user.getPlace());
    }
}
