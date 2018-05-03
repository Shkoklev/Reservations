package com.sorsix.interns.reservations.api;

import com.sorsix.interns.reservations.service.CompanyImageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/images")
public class CompanyImageController {

    private final CompanyImageService companyImageService;

    public CompanyImageController(CompanyImageService companyImageService) {
        this.companyImageService = companyImageService;
    }


}
