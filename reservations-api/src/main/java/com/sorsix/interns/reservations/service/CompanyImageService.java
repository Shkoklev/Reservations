package com.sorsix.interns.reservations.service;

import com.sorsix.interns.reservations.model.CompanyImage;
import com.sorsix.interns.reservations.repository.CompanyImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyImageService {

    private final CompanyImageRepository companyImageRepository;

    public CompanyImageService(CompanyImageRepository repository) {
        this.companyImageRepository = repository;
    }

    public List<CompanyImage> getImages() {
        return companyImageRepository.findAll();
    }

    public List<CompanyImage> saveImage(List<CompanyImage> image){
        return companyImageRepository.saveAll(image);
    }
}
