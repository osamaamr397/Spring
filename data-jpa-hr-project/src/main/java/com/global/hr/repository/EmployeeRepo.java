package com.global.hr.repository;

import com.global.hr.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    //NamedQuery
    List<Employee>findSalary(Double salary);
    List<Employee>findByNameContainingAndDepartmentNameContaining(String empName,String depName);
    Long countByNameContainingAndDepartmentNameContaining(String empName,String depName);
    @Modifying(clearAutomatically = true,flushAutomatically = true)
    @Transactional
    Long deleteByNameContainingAndDepartmentNameContaining(String empName,String depName);

    // this is the sql native
    @Query(value = "select * from hr_employees emp where emp.first_Name like :empName", nativeQuery = true)
    List<Employee> filterNative(@Param("empName") String name);
    List<Employee>findByDepartmentId(Long deptId);
    @Query(value = "select emp from Employee emp join emp.department dept where dept.id = :deptId ")
    List <Employee> findByDepartment(Long deptId);
}
