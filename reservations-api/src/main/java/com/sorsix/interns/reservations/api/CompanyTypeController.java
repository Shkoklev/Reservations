package com.sorsix.interns.reservations.api;

import com.sorsix.interns.reservations.model.CompanyType;
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

}
