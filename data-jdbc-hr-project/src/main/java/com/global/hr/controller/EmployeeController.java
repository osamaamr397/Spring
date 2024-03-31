package com.global.hr.controller;

import com.global.hr.Service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.global.hr.entity.Employee;
import com.global.hr.repository.EmployeeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    Logger log= LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeService employeeService;
    // @GetMapping("/count")
    @RequestMapping(method = RequestMethod.GET,path = "/count")
    public Long countEmp(){
        return employeeService.count();
    }
    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id,@RequestHeader("accept-language")String acceptLang){
      log.info("Accept Language is "+acceptLang);
        return employeeService.findById(id);
    }
    @GetMapping("")
    public Iterable<Employee> findAll(){
        return employeeService.findAll();
    }
    @PostMapping("/insert")

    public Employee addEmp(@RequestBody Employee employee){
        return employeeService.addEmp(employee);
    }
    @PostMapping("/insert2")
    public ResponseEntity<?> addEmp2(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.addEmp(employee)) ;
        //or
       // return new ResponseEntity<>(employeeRepo.save(employee), HttpStatus.OK);
    }
    @PutMapping("")
    public Employee updateEmp(@RequestBody Employee employee){

        return employeeService.updateEmp(employee);
    }
    @GetMapping("/filter/{name}")
    public List<Employee>filter(@PathVariable String name){
        return employeeService.findByName(name);
    }
    @GetMapping("/filter/{name}/{salary}")
    public List<Employee>filter(@PathVariable String name,@PathVariable double salary){
        return employeeService.findByNameStartingWithAndSalary(name,salary);
    }
    //we use pathVariable when we need to delete as i should send the id
    @GetMapping("/filter")
    public List<Employee>filter2(@RequestParam String name,@RequestParam double salary){
        return employeeService.findByNameAndSalary(name,salary);
    }
    @GetMapping("/search/{name}/{salary}")
    public List<Employee>search(@PathVariable String name,@PathVariable Double salary){
        return employeeService.searchByNameAndSalary(name,salary);
    }
    @DeleteMapping("/{empId}")
    public void deleteEmp(@PathVariable(name = "empId")Long id){
        employeeService.deleteEmp(id);
    }
    public void testJackson() throws JsonMappingException,JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        String jsonString = "{\r\n"
                + "        \"employeeId\": 20,\r\n"
                + "        \"name\": \"Mohamed\",\r\n"
                + "        \"salary\": 5221.0,\r\n"
                + "        \"isCreate\": null\r\n"
                + "    }";
        //object to json conversion
        Employee student=mapper.readValue(jsonString,Employee.class);
        //object to json conversion
        jsonString=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
    }
    @PutMapping("/salary")
    public  int updateSalary(@RequestParam Double salary,@RequestParam Long id){
        return employeeService.updateSalary(salary,id);
    }
}
