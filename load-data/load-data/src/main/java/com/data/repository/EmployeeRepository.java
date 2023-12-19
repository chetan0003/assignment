package com.data.repository;

import com.data.domain.EmployeeDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeDetail,Long> {

}
