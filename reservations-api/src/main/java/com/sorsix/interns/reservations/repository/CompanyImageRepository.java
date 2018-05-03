package com.sorsix.interns.reservations.repository;

import com.sorsix.interns.reservations.model.CompanyImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyImageRepository extends JpaRepository<CompanyImage, Long>{
}
