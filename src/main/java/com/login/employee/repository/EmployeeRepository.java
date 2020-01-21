package com.login.employee.repository;

import com.login.employee.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    //Using Spring JPA functionality to get DB Data
    Optional<Employee> findByEmail(String email);

}
