package com.sorsix.interns.reservations.api;

import com.sorsix.interns.reservations.model.Company;
import com.sorsix.interns.reservations.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public Company saveCompany(@RequestBody Company company) {
        return companyService.saveCompany(company);
    }

    @GetMapping
    public List<Company> getCompanies() {
        return companyService.getCompanies();

    }

    @GetMapping("/{companyType}")
    public List<Company> getCompaniesByType(@PathVariable String companyType) {
        return companyService.getCompaniesByType(companyType);
    }

    @GetMapping("/id/{id}")
    public Company getCompany(@PathVariable Long id) {
        System.out.println("hello");
        return companyService.getCompany(id).orElse(null);
    }

    @GetMapping("/places/{id}")
    public List<Company> getCompaniesByPlace(@PathVariable Long id) {
        return companyService.getCompaniesByPlace(id);
    }
}
