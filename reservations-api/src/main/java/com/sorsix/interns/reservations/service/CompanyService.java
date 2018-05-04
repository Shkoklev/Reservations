package com.sorsix.interns.reservations.service;

import com.sorsix.interns.reservations.model.Company;
import com.sorsix.interns.reservations.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository repository;

    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    public List<Company> getCompanies(String type, String place) {
        if(type == null && place == null) {
            return getAllCompanies();
        }else if(type != null && place != null) {
            return getCompaniesByTypeAndPlace(type, place);
        }else if(type != null) {
            return getCompaniesByType(type);
        }else {
            return getCompaniesByPlace(place);
        }
    }

    public List<Company> getAllCompanies(){
        return repository.findAll();
    }

    public Optional<Company> getCompany(Long id) {
        return repository.findById(id);
    }

    public List<Company> getCompaniesByType(String companyTypeName) {
        return repository.findByCompanyType_Name(companyTypeName);
    }

    public List<Company> getCompaniesByPlace(String placeName) {
        return repository.findByPlace_Name(placeName);
    }

    public List<Company> getCompaniesByTypeAndPlace(String companyTypeName, String placeName) {
        return repository.findByCompanyType_NameAndPlace_Name(companyTypeName, placeName);
    }

    public Company saveCompany(Company company){
        return repository.save(company);
    }

}
