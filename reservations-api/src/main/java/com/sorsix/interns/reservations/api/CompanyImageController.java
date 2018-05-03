package com.sorsix.interns.reservations.api;

import com.sorsix.interns.reservations.model.CompanyImage;
import com.sorsix.interns.reservations.service.CompanyImageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/images")
public class CompanyImageController {

    private final CompanyImageService companyImageService;

    public CompanyImageController(CompanyImageService companyImageService) {
        this.companyImageService = companyImageService;
    }

    @PostMapping("/save")
    public List<CompanyImage> saveCompanyImages(List<CompanyImage> companyImages){
        return companyImageService.saveImages(companyImages);
    }

}
