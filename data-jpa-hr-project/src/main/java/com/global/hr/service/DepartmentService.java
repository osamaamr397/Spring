package com.global.hr.service;

import com.global.hr.entity.Department;
import com.global.hr.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;
    public Department findById(Long id){
        return departmentRepo.findById(id).orElseThrow();
    }
    public Department insert(Department department){
        return departmentRepo.save(department);
    }
    public Department update(Department department){
        Department current=departmentRepo.findById(department.getId()).get();
        current.setName(department.getName());
        return departmentRepo.save(current);
    }
    public List<Department> findAll(){

        return departmentRepo.findAll();
    }

}
