package com.tw.apistackbase.controller;

import com.tw.apistackbase.entity.Employee;
import com.tw.apistackbase.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping("/employees")
    public ResponseEntity getAllEmployees(@RequestParam(value = "page",defaultValue = "0")int page,
                                          @RequestParam(value = "pageSize",defaultValue = "0")int pageSize){
        if(page == 0 || pageSize ==0){
            return ResponseEntity.ok(employeeRepository.getEmployees());
        }
        int endIndex = page * pageSize;
        if(endIndex > employeeRepository.getEmployees().size()){
            endIndex = employeeRepository.getEmployees().size();
        }
        return ResponseEntity.ok(employeeRepository.getEmployees().subList((page-1)*pageSize,endIndex));
    }
    @GetMapping("/employees/{employeeId}")
    public ResponseEntity getEmployeeById(@PathVariable long employeeId){
        Employee findEmployee = employeeRepository.getEmployees().stream()
                .filter(employee -> employee.getId() == employeeId)
                .findFirst().orElse(null);
        if(findEmployee!= null){
            return ResponseEntity.ok(findEmployee);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping(value = "/employees",params = {"gender"})
    public ResponseEntity<List<Employee>> getEmployeeByGender(@RequestParam(value = "gender",defaultValue = "male") String gender){
        List<Employee> employees = employeeRepository.getEmployees().stream()
                .filter(employee -> employee.getGender().equals(gender)).collect(Collectors.toList());
        return ResponseEntity.ok(employees);
    }
    @PostMapping("/employees")
    public ResponseEntity addEmployee(@RequestBody Employee employee){
        employee.setId(12);
        employeeRepository.getEmployees().add(employee);
        return ResponseEntity.ok(employeeRepository.getEmployees().get(employeeRepository.getEmployees().size()-1));
    }
}
