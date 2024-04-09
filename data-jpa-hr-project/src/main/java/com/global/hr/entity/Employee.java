package com.global.hr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
//@Table(name = "employee")
//@NamedQuery(name = "Employee.findSalary",query = "select emp from employee emp where emp.salary>= :salary")
/*
@SqlResultSetMapping(
        name = "empMapping",
        entities = @EntityResult(
                entityClass = Employee.class,
                fields = {
                    @FieldResult(name = "id", column = "emp_id"),
                    @FieldResult(name = "name", column = "name"),
                    @FieldResult(name = "salary", column = "salary")}))

@NamedNativeQuery(name = "Employee.findByDepartment" , query = "select emp.emp_id, emp.emp_name, emp.salary"
		+ " from employee emp where emp.department_id = :deptId", resultSetMapping = "empMapping")
*/
public class Employee {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "salary")
    private double salary;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id",referencedColumnName = "id")

    private Department department;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Employee(){}
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
