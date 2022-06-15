package com.rest.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.backend.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
