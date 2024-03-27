package com.global.hr.controller;

import com.global.hr.model.Employee;
import com.global.hr.repository.EmployeeReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    @Qualifier("employeeNamedParameterJDBCRepo")
    private EmployeeReps employeeReps;

    @GetMapping("/count")
    public int countEmployees(){
        return employeeReps.count();
    }
    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id){
        return employeeReps.FindbyId(id);
    }
    @GetMapping("")
    public List<Employee>findAll(){
        return employeeReps.findAll();
    }

}
