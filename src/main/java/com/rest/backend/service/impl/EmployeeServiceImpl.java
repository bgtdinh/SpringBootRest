package com.rest.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rest.backend.exception.ResourceNotFoundException;
import com.rest.backend.model.Employee;
import com.rest.backend.repository.EmployeeRepository;
import com.rest.backend.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

  private EmployeeRepository employeeRepository;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    super();
    this.employeeRepository = employeeRepository;
  }



  @Override
  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }



  @Override
  public Employee saveEmployee(Employee employee) {
    return employeeRepository.save(employee);
  }



  @Override
  public Employee getEmployeeById(long id) {
    Optional<Employee> employee = employeeRepository.findById(id);

    // if(employee.isPresent()) {
    //   return employee.get();
    // } else {
    //   throw new ResourceNotFoundException("Employee", "Id", id);
    // }


    //lamda expression
    return employeeRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Employee", "Id", id));
  }



  @Override
  public Employee updateEmployee(Employee employee, long id) {

    //check if employee exists
    Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));

    existingEmployee.setFirstName(employee.getFirstName());
    existingEmployee.setLastName(employee.getLastName());
    existingEmployee.setEmail(employee.getEmail());

    employeeRepository.save(existingEmployee);
    return existingEmployee;
  }


}
