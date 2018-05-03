package com.sorsix.interns.reservations.service;

import com.sorsix.interns.reservations.model.Company;
import com.sorsix.interns.reservations.model.CompanyType;
import com.sorsix.interns.reservations.repository.CompanyRepository;
import com.sorsix.interns.reservations.repository.CompanyTypeRepository;
import com.sorsix.interns.reservations.repository.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyTypeRepository companyTypeRepository;

    public CompanyService(CompanyRepository companyRepository,CompanyTypeRepository companyTypeRepository) {
        this.companyRepository=companyRepository;
        this.companyTypeRepository=companyTypeRepository;
    }

    public List<Company> getCompaniesByType(String companyType) {
        return companyRepository.getByCompanyType_Name(companyType);
    }

    public Optional<Company> getCompany(Long id) {
        return companyRepository.findById(id);
    }

    public List<CompanyType> getCompanyTypes() {
        return companyTypeRepository.findAll();
    }

    public List<Company> getCompaniesByPlace(Long id) {
        return companyRepository.getByPlaceId(id);
    }

}
