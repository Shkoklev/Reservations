package com.sorsix.interns.reservations.service;

import com.sorsix.interns.reservations.model.CompanyType;
import com.sorsix.interns.reservations.repository.CompanyTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyTypeService {

    private final CompanyTypeRepository companyTypeRepository;

    public CompanyTypeService(CompanyTypeRepository repository) {
        this.companyTypeRepository = repository;
    }

    public List<CompanyType> getCompanyTypes() {
        return companyTypeRepository.findAll();
    }

    public CompanyType saveCompanyType(CompanyType companyType){
        return companyTypeRepository.save(companyType);
    }
}
