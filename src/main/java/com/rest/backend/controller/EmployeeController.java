package com.rest.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.backend.model.Employee;
import com.rest.backend.service.EmployeeService;


@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

  private EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    super();
    this.employeeService = employeeService;
  }

  //build create employee REST API
  @PostMapping
  public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {

    return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
  }

  //get all employees
  @GetMapping
  public List<Employee> getAllEmployees(){
    return employeeService.getAllEmployees();
  }

  //get employee by ID
  @GetMapping("{id}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long EmployeeId){
    return new ResponseEntity<Employee>(employeeService.getEmployeeById(EmployeeId), HttpStatus.OK);
  }

  //update employee
  @PutMapping("{id}")
  public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long EmployeeId, @RequestBody Employee employee){
    return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, EmployeeId), HttpStatus.OK);
  }

}
