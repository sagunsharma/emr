package com.candela.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.candela.entity.DepartmentDetails;

@Repository
public interface DepartmentDetailsRepository extends JpaRepository<DepartmentDetails, String> {

}
