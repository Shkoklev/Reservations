package com.sorsix.interns.reservations.service;

import com.sorsix.interns.reservations.model.CompanyType;
import com.sorsix.interns.reservations.repository.CompanyTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyTypeService {

    private final CompanyTypeRepository repository;

    public CompanyTypeService(CompanyTypeRepository repository) {
        this.repository = repository;
    }

    public List<CompanyType> getCompanyTypes() {
        return repository.findAll();
    }

    public CompanyType saveCompanyType(CompanyType companyType){
        return repository.save(companyType);
    }
}
