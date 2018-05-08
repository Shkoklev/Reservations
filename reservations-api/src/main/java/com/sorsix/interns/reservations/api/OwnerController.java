package com.sorsix.interns.reservations.api;

import com.sorsix.interns.reservations.model.Owner;
import com.sorsix.interns.reservations.service.OwnerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/register")
    public Owner registerOwner(@RequestBody Owner owner) {
        return ownerService.saveOwner(owner.getFirstName(), owner.getLastName(), owner.getEmail(), owner.getPassword());
    }
}
