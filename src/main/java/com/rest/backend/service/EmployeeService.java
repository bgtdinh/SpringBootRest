package com.rest.backend.service;

import java.util.List;

import com.rest.backend.model.Employee;

public interface EmployeeService {
  Employee saveEmployee(Employee employee);
  List<Employee> getAllEmployees();
  Employee getEmployeeById(long id);
  Employee updateEmployee(Employee employee, long id);
}
