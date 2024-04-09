package com.global.hr.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "hr_departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "depratment_gen")
//	@SequenceGenerator(name = "depratment_gen" , sequenceName = "department_seq", initialValue = 100)
//
//	@GeneratedValue(strategy = GenerationType.TABLE, generator = "depratment_gen")
//	@TableGenerator(name = "depratment_gen", table = "depratment_seq", allocationSize = 1, initialValue = 20)

    private Long id;
    @Column(name = "dep_name")
    private String name;
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
    public Long getId() {
        return id;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
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
}
