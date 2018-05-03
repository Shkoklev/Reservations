package com.sorsix.interns.reservations.repository;

import com.sorsix.interns.reservations.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> getByCompanyType_Name(String companyType);
    List<Company> getByPlaceId(Long id);
}
