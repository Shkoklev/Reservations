package com.sorsix.interns.reservations.api;

import com.sorsix.interns.reservations.model.CompanyImage;
import com.sorsix.interns.reservations.service.CompanyImageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/images")
public class CompanyImageController {

    private final CompanyImageService companyImageService;

    public CompanyImageController(CompanyImageService companyImageService) {
        this.companyImageService = companyImageService;
    }

    @PostMapping
    public List<CompanyImage> saveCompanyImage(@RequestBody List<CompanyImage> companyImage){
        return companyImageService.saveImage(companyImage);
    }

    @GetMapping
    public List<CompanyImage> getImages() {
        return companyImageService.getImages();
    }

}
