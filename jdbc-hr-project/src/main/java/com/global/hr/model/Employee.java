package com.global.hr.model;


public class Employee {
    private Long employeeId;
    private String name;


    public Employee(){
        super();
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Employee(Long employeId, String name, double salary) {
        super();
        this.employeeId = employeId;
        this.name = name;
        this.salary = salary;
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

    private double salary;
}
