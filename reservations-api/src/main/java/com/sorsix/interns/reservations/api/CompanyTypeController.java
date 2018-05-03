package com.sorsix.interns.reservations.api;

import com.sorsix.interns.reservations.model.CompanyType;
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
}
