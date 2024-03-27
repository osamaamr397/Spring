package com.global.hr.controller;

import com.global.hr.entity.Employee;
import com.global.hr.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeRepo employeeRepo;
    @Autowired
     public EmployeeController(EmployeeRepo employeeRepo){
         super();
         this.employeeRepo=employeeRepo;
     }
     @GetMapping("/count")
    public Long countEmp(){
        return employeeRepo.count();
    }
    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id){
        return employeeRepo.findById(id).get();
    }
    @GetMapping("")
    public Iterable<Employee> findAll(){
        return employeeRepo.findAll();
    }
    @GetMapping("/insert")

    public Employee addEmp(){
        return employeeRepo.save(new Employee(null,"Otaka",548412.4));
    }
    @GetMapping("/update")
    public Employee updateEmp(){

        return employeeRepo.save(new Employee(50L,"ZAZA",595.2));
    }
    @GetMapping("/filter/{name}")
    public List<Employee>filter(@PathVariable String name){
        return employeeRepo.findByName(name);
    }
    @GetMapping("/filter/{name}/{salary}")
    public List<Employee>filter(@PathVariable String name,@PathVariable double salary){
        return employeeRepo.findByNameAndSalary(name,salary);
    }
    @GetMapping("/search/{name}/{salary}")
    public List<Employee>search(@PathVariable String name,@PathVariable Double salary){
        return employeeRepo.searchByNameAndSalary(name,salary);
    }

}
