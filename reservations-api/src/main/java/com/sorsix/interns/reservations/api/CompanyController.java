package com.sorsix.interns.reservations.api;

import com.sorsix.interns.reservations.model.Company;
import com.sorsix.interns.reservations.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/{companyType}")
    public List<Company> getCompaniesByType(@PathVariable String companyType) {
        return companyService.getCompaniesByType(companyType);
    }

    @GetMapping
    public Company getCompany(@RequestParam("id") Long id) {
        System.out.println("hello");
        return companyService.getCompany(id).orElse(null);
    }

    @GetMapping("/place")
    public List<Company> getCompaniesByPlace(@RequestParam("placeId") Long placeId) {
        return companyService.getCompaniesByPlace(placeId);
    }
}
