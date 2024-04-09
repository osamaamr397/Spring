package com.global.hr.controller;

import com.global.hr.entity.Employee;
import com.global.hr.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;
    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id){
        return employeeService.findById(id);
    }
    @PostMapping("/insert")
    public Long insert(@RequestBody Employee employee){

        Employee inserted=employeeService.insert(employee);
        return inserted.getId();
    }
    @PutMapping("/update")

    public Employee update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }
    @GetMapping("/department/{deptId}")
    public List<Employee> findByDepartmentId(@PathVariable Long deptId){
        return employeeService.findByDepartmentId(deptId);
    }
    @GetMapping("/departmentV2/{deptId}")
    public List<Employee> findByDepartment(@PathVariable Long deptId){
        return employeeService.findByDepartment(deptId);
    }
    @GetMapping("")
    public List<Employee> findAll() {

        return employeeService.findAll();
    }
    @GetMapping("/emp-dept")
    public List<Employee>findByNameAndDep(@RequestParam String empName,@RequestParam String depName){
        return employeeService.findByEmpAndDep(empName,depName);
    }
    @GetMapping("/count-emp-dept")
    public ResponseEntity<Long> countNameAndDep(@RequestParam String empName, @RequestParam String depName){
        return ResponseEntity.ok(employeeService.countByEmpAndDep(empName,depName));
    }
    @DeleteMapping("/emp-dept")
    public ResponseEntity<Long>deleteNameAndDep(@RequestParam String empName, @RequestParam String depName){
        return ResponseEntity.ok(employeeService.deleteByEmpAndDep(empName,depName));
    }
    @GetMapping("/salary")
    public ResponseEntity<?>findSalary(@RequestParam Double salary){
        return ResponseEntity.ok(employeeService.findSalary(salary));
    }


}
