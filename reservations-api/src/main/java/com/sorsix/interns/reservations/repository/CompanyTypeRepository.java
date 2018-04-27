package com.sorsix.interns.reservations.repository;

import com.sorsix.interns.reservations.model.CompanyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyTypeRepository  extends JpaRepository<CompanyType, Long>{
}
