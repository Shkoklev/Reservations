package com.sorsix.interns.reservations.service;

import com.sorsix.interns.reservations.model.CompanyImage;
import com.sorsix.interns.reservations.repository.CompanyImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyImageService {

    private final CompanyImageRepository repository;

    public CompanyImageService(CompanyImageRepository repository) {
        this.repository = repository;
    }

    public List<CompanyImage> getImages() {
        return repository.findAll();
    }

    public CompanyImage saveImages(CompanyImage images){
        return repository.save(images);
    }
}
