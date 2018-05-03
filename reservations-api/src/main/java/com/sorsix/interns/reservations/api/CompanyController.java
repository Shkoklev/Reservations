package com.sorsix.interns.reservations.api;

import com.sorsix.interns.reservations.model.Company;
<<<<<<< HEAD
import com.sorsix.interns.reservations.model.CompanyImage;
import com.sorsix.interns.reservations.service.CompanyImageService;
=======
>>>>>>> 892e05ba7bbfb20f7888c82935f5e5c2c2a997b0
import com.sorsix.interns.reservations.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

<<<<<<< HEAD
    private final CompanyService companyService;
    private final CompanyImageService companyImageService;
    public CompanyController(CompanyService companyService, CompanyImageService companyImageService) {
        this.companyService = companyService;
        this.companyImageService = companyImageService;
    }

    @PostMapping
    public Company saveCompany(@RequestBody Company company){
       return companyService.saveCompany(company);
    }

    @PostMapping("images")
    public List<CompanyImage> saveImages(@RequestBody List<CompanyImage> images){
        return companyImageService.saveImages(images);
    }


    @GetMapping
    public List<Company> getCompanies(){
        return companyService.getCompanies();
=======
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
>>>>>>> 892e05ba7bbfb20f7888c82935f5e5c2c2a997b0
    }
}
