package com.global.hr.repository;

import com.global.hr.entity.Employee;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee,Long> {
    List<Employee>findByName(String name);

    List<Employee>findByNameAndSalary(String name,double salary);
    List<Employee>findByNameStartingWithAndSalary(String name,Double salary);
   // List<Employee>findByNameContainingAndSalaryGreaterThanEqual(String name,Double salary);
    @Query(value = "SELECT * FROM employees where name like :empName and salary >= :empSalary")
    List<Employee>searchByNameAndSalary(@Param("empName")String name,@Param("empSalary") Double salary);
    public List<Employee>findByEmployeeId(String name);
    @Modifying //to tell the db that i'am going to make transactional behavior to the db
    @Query(value = "update employees set salary = :salary where id= :id ")
    int updateSalary(Double salary,Long id);
}
