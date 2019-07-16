package com.tw.apistackbase.controller;

import com.tw.apistackbase.entity.Company;
import com.tw.apistackbase.entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
public class CompanyController {
    private List<Employee> firstEmployees = Arrays.asList(
            new Employee(1,"alibaba1",20,"male",6000),
            new Employee(2,"aliba2",19,"male",7000),
            new Employee(4,"alibayy",21,"female",8000));
    private List<Employee> secondEmployees = Arrays.asList(
            new Employee(1,"tengxun1",20,"male",9000),
            new Employee(7,"ateng2",19,"female",7000));
    private List<Company> companys = Arrays.asList(
            new Company(1,"alibaba",firstEmployees,3),
            new Company(2,"tengxun",secondEmployees,2));
    @GetMapping("/companies")
    public ResponseEntity getAllCompanies(){
        return ResponseEntity.ok(companys);
    }
    @GetMapping("/companies/{companyId}")
    public ResponseEntity getSpecificCompany(@PathVariable long companyId){
        return ResponseEntity.ok(companys.stream()
                .filter(company -> company.getCompanyId()==companyId)
                .findFirst()
                .orElse(null));
    }
    @GetMapping("/companies/{companyId}/employees")
    public ResponseEntity getEmployeesOfSpecificCompany(@PathVariable long companyId){
        Company specificCompany = companys.stream()
                .filter(company -> company.getCompanyId()==companyId)
                .findFirst()
                .orElse(null);
        if(specificCompany!= null){
            return ResponseEntity.ok(specificCompany.getEmployees());
        }
        return ResponseEntity.notFound().build();
    }
}
