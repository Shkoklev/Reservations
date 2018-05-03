package com.sorsix.interns.reservations.service;

import com.sorsix.interns.reservations.model.Company;
import com.sorsix.interns.reservations.repository.CompanyRepository;
import com.sorsix.interns.reservations.repository.CompanyTypeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository repository;
    private final CompanyTypeRepository typeRepository;

    public CompanyService(CompanyRepository repository, CompanyTypeRepository typeRepository) {
        this.repository = repository;
        this.typeRepository = typeRepository;
    }

    public Company saveCompany(Company company){
        return repository.save(company);
    }

    public List<Company> getCompanies(){
        return repository.findAll();
    }

}
