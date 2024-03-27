package com.global.hr.repository.imp;

import com.global.hr.mapper.EmployeeMapper;
import com.global.hr.model.Employee;
import com.global.hr.repository.EmployeeReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository //to tell spring that bean which in container worked with database
/*
* so if the class worked with database so Repository should be used not component
* */
//@Component
@Primary
public class EmployeeJDBCReps implements EmployeeReps {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int count() {
        //                                 return data type
      return jdbcTemplate.queryForObject("select count(*) from employees",Integer.class);

    }

    @Override
    public Employee FindbyId(Long id) {

        return jdbcTemplate.queryForObject("select id, name, salary from employees where id =?",new Object[]{id}, new EmployeeMapper());
    }

    @Override
    public List<Employee> findByNameAndSalary(String name, Double salary) {
        return null;
    }


    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query("select * from employees",new EmployeeMapper());

    }

    @Override
    public int insert(Employee employee) {
        return jdbcTemplate.update("insert into employees (id, name, salary) values (?,?,?)",
                new Object[]{employee.getEmployeeId(),employee.getName(),employee.getSalary()});

    }

    @Override
    public int update(Employee employee) {
        return jdbcTemplate.update("update employees set name= ? ,salary= ?",
                new Object[]{employee.getName(),employee.getSalary()});

    }

    @Override
    public int delete(Long id) {
        return jdbcTemplate.update("delete from employees where id=?",
                new Object[]{id});
    }
}
