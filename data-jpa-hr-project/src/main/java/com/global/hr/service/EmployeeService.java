package com.global.hr.service;

import com.global.hr.entity.Employee;
import com.global.hr.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private DepartmentService departmentService;
    public Employee findById(Long id){
       return employeeRepo.findById(id).orElseThrow();
    }
    public List<Employee> filter(String name){
        return employeeRepo.filterNative(name);
    }
    public Employee insert(Employee employee){
        if(employee.getDepartment()!=null&&employee.getDepartment().getId()!=null){
            employee.setDepartment(departmentService.findById(employee.getDepartment().getId()));
        }
        return employeeRepo.save(employee);
    }
    public Employee update(Employee employee){
        Employee current=employeeRepo.findById(employee.getId()).get();
        current.setName(employee.getName());
        current.setSalary(employee.getSalary());
        current.setDepartment(employee.getDepartment());
        return employeeRepo.save(current);
    }
    public List<Employee>findByDepartmentId(Long deptId){
        return employeeRepo.findByDepartmentId(deptId);
    }
    public List<Employee>findByDepartment(Long deptId){
        return employeeRepo.findByDepartment(deptId);
    }
    public List<Employee> findAll() {

        return employeeRepo.findAll();
    }


    public List<Employee>findByEmpAndDep(String empName,String depName){
        return employeeRepo.findByNameContainingAndDepartmentNameContaining(empName,depName);
    }
    public Long countByEmpAndDep(String empName,String depName){
        return employeeRepo.countByNameContainingAndDepartmentNameContaining(empName,depName);
    }
    public Long deleteByEmpAndDep(String empName,String depName){
        return employeeRepo.deleteByNameContainingAndDepartmentNameContaining(empName,depName);
    }
    public List<Employee>findSalary(Double salary){
        return  employeeRepo.findSalary(salary);
    }

}
