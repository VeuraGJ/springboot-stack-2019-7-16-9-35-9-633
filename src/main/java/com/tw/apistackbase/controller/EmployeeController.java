package com.tw.apistackbase.controller;

import com.tw.apistackbase.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
