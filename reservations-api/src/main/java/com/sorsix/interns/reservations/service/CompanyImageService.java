package com.sorsix.interns.reservations.service;

import com.sorsix.interns.reservations.model.CompanyImage;
import com.sorsix.interns.reservations.repository.CompanyImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyImageService {

    private final CompanyImageRepository  companyImageRepository;

    public CompanyImageService(CompanyImageRepository companyImageRepository) {
        this.companyImageRepository = companyImageRepository;
    }

    public List<CompanyImage> saveImages(List<CompanyImage> images){
        return companyImageRepository.saveAll(images);
    }
}
