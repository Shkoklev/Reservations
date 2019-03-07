package com.sorsix.interns.reservations.api;

import com.sorsix.interns.reservations.model.Company;
import com.sorsix.interns.reservations.model.Owner;
import com.sorsix.interns.reservations.model.requests.OwnerRequest;
import com.sorsix.interns.reservations.service.CompanyService;
import com.sorsix.interns.reservations.service.OwnerService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {

    private final OwnerService ownerService;
    private final CompanyService companyService;

    public OwnerController(OwnerService ownerService, CompanyService companyService) {
        this.ownerService = ownerService;
        this.companyService = companyService;
    }

    @PostMapping("/register")
    public Owner registerOwner(@RequestBody OwnerRequest request) {
        return ownerService.saveOwner(request.firstName, request.lastName, request.email, request.password);
    }

    @GetMapping("/companies")
    public List<Company> getOwnerCompanies(Authentication authentication) {
        Owner loggedOwner = (Owner)authentication.getPrincipal();
        return companyService.getCompaniesByOwnerId(loggedOwner.getId());
    }

    @GetMapping("/loggedOwner")
    public Owner getLoggedOwner(Authentication authentication) {
        return (Owner)authentication.getPrincipal();
    }


    @PostMapping("/add/company")
    public Company saveCompany(@RequestBody Company company, Authentication authentication)
    {
        company.setOwner((Owner)authentication.getPrincipal());
        return companyService.saveCompany(company);
    }

}
