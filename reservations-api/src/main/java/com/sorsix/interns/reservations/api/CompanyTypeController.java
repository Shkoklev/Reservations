package com.sorsix.interns.reservations.api;

import com.sorsix.interns.reservations.model.CompanyType;
<<<<<<< HEAD
import com.sorsix.interns.reservations.service.CompanyTypeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/types")
public class CompanyTypeController {

    private final CompanyTypeService companyTypeService;

    public CompanyTypeController(CompanyTypeService companyTypeService) {
        this.companyTypeService = companyTypeService;
    }

    @PostMapping
    public CompanyType saveCompanyType(@RequestBody CompanyType companyType){
        return companyTypeService.saveCompanyType(companyType);
    }

=======
import com.sorsix.interns.reservations.service.CompanyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companyTypes")
public class CompanyTypeController {

    public CompanyService companyService;

    public CompanyTypeController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<CompanyType> getCompanyTypes() {
        return companyService.getCompanyTypes();
    }
>>>>>>> 892e05ba7bbfb20f7888c82935f5e5c2c2a997b0
}
