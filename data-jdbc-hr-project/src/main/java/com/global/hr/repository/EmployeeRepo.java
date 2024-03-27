package com.global.hr.repository;

import com.global.hr.entity.Employee;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee,Long> {
    List<Employee>findByName(String name);
    List<Employee>findByNameAndSalary(String name,double salary);
    List<Employee>findByNameStartingWithAndSalary(String name,Double salary);
   // List<Employee>findByNameContainingAndSalaryGreaterThanEqual(String name,Double salary);
    @Query(value = "SELECT * FROM employees where name like :empName and salary >= :empSalary")
    List<Employee>searchByNameAndSalary(@Param("empName")String name,@Param("empSalary") Double salary);

}
