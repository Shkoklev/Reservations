package com.sorsix.interns.reservations.repository;

import com.sorsix.interns.reservations.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findByCompanyType_Name(String companyTypeName);
    List<Company> findByPlace_Name(String placeName);
    List<Company> findByCompanyType_NameAndPlace_Name(String companyTypeName, String placeName);
    List<Company> findByOwner_Id(Long id);

}
