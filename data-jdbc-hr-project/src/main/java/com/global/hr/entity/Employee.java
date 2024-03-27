package com.global.hr.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.InsertOnlyProperty;
import org.springframework.data.relational.core.mapping.Table;

@Table("employees")
public class Employee {
    @Id
    @Column("id")
    private Long employeeId;
    @Column("name")
    private String name;
    @Column("salary")
    private Double salary;

        @Transient // to tell that this property only exist in the class not in database
    private boolean isCreate;

    public boolean isCreate() {
        return isCreate;
    }

    public void setCreate(boolean create) {
        isCreate = create;
    }

    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Employee(Long employeeId, String name, Double salary) {
        super();
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

}