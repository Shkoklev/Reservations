package com.sorsix.interns.reservations.api;

import com.sorsix.interns.reservations.model.CompanyType;
import com.sorsix.interns.reservations.service.CompanyService;
import com.sorsix.interns.reservations.service.CompanyTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/types")
public class CompanyTypeController {

    private final CompanyTypeService companyTypeService;
    private final CompanyService companyService;


    public CompanyTypeController(CompanyTypeService companyTypeService, CompanyService companyService) {
        this.companyTypeService = companyTypeService;
        this.companyService = companyService;
    }

    @PostMapping
    public CompanyType saveCompanyType(@RequestBody CompanyType companyType) {
        return companyTypeService.saveCompanyType(companyType);
    }

    @GetMapping
    public List<CompanyType> getCompanyTypes() {
        return companyService.getCompanyTypes();
    }
}





