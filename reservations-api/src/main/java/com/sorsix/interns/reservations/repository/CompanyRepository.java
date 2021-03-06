package com.sorsix.interns.reservations.repository;

import com.sorsix.interns.reservations.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findByNameStartingWithIgnoreCase(String query);
    List<Company> findByCompanyType_Name(String companyTypeName);
    List<Company> findByPlace_Name(String placeName);
    List<Company> findByCompanyType_NameAndPlace_Name(String companyTypeName, String placeName);
    List<Company> findByOwner_Id(Long id);
    Optional<Company> findByName(String name);

}
