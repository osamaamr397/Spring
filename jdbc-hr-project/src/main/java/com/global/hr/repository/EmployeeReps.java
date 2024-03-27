package com.global.hr.repository;

import com.global.hr.model.Employee;

import java.util.List;

public interface EmployeeReps {
    int count();
    Employee FindbyId(Long id);
    List <Employee> findByNameAndSalary(String name,Double salary);
    List<Employee>findAll();
    int insert(Employee employee);
    int update(Employee employee);
    int delete(Long id);
}
