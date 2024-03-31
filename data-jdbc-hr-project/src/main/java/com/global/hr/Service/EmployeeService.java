package com.global.hr.Service;

import com.global.hr.entity.Employee;
import com.global.hr.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
  private   EmployeeRepo employeeRepo;
    @Autowired

    public EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo=employeeRepo;
    }

public Long count(){
    return employeeRepo.count();
}
  public   List<Employee>searchByNameAndSalary(@Param("empName")String name, @Param("empSalary") Double salary)
    {
        return employeeRepo.searchByNameAndSalary(name, salary);
    }
    public Employee findById(Long id) {

        return employeeRepo.findById(id).get();
    }
    public Iterable<Employee> findAll(){

        return employeeRepo.findAll();
    }
    public Employee addEmp(@RequestBody Employee employee){
        return employeeRepo.save(employee);
    }
    public Employee updateEmp(@RequestBody Employee employee){

        return employeeRepo.save(employee);
    }
    public void deleteEmp(@PathVariable(name = "empId")Long id){

        employeeRepo.deleteById(id);
    }
   public List<Employee> findByName(String name){
        return employeeRepo.findByName(name);
    }
    public List<Employee>findByNameAndSalary(String name,double salary){
        return employeeRepo.findByNameAndSalary(name,salary);
    }
    public List<Employee>findByNameStartingWithAndSalary(String name,Double salary){
        return employeeRepo.findByNameStartingWithAndSalary(name, salary);
    }
    public List<Employee>findByEmployeeId(String name){
        return employeeRepo.findByEmployeeId(name);
    }
    public  int updateSalary(Double salary,Long id){
        return employeeRepo.updateSalary(salary,id);
    }

}
