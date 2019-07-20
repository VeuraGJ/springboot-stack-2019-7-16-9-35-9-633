package com.tw.apistackbase.controller;

import com.tw.apistackbase.entity.Company;
import com.tw.apistackbase.entity.Employee;
import com.tw.apistackbase.respository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class CompanyController {
   @Autowired
   private CompanyRepository companyRepository;
    @GetMapping("/companies")
    public ResponseEntity getAllCompanies(){
        return ResponseEntity.ok(companyRepository.getCompanys());
    }
//    @GetMapping("/companies/{companyId}")
//    public ResponseEntity getSpecificCompany(@PathVariable long companyId){
//        Company specificCompany = companyService.getCompanys().stream()
//                .filter(company -> company.getCompanyId()==companyId)
//                .findFirst()
//                .orElse(null);
//        if(specificCompany!= null){
//            return ResponseEntity.ok(specificCompany);
//        }
//        return ResponseEntity.notFound().build();
//    }
//    @GetMapping("/companies/{companyId}/employees")
//    public ResponseEntity getEmployeesOfSpecificCompany(@PathVariable long companyId) {
//        Company specificCompany = companyService.getCompanys().stream()
//                .filter(company -> company.getCompanyId() == companyId)
//                .findFirst()
//                .orElse(null);
//        if (specificCompany != null) {
//            return ResponseEntity.ok(specificCompany.getEmployees());
//        }
//        return ResponseEntity.notFound().build();
//    }
//    @GetMapping(path = "/companies",params = "page,pageSize")
//    public String queryCompaniesByPage(@RequestParam("page") int page,@RequestParam("pageSize") int pageSize){
//
//        return String.valueOf(page+pageSize);
//    }
//    @PostMapping("/companies")
//    public ResponseEntity createCompany(@RequestBody Company company){
//        company.setCompanyId(11);
//        companyService.getCompanys().add(company);
//        return ResponseEntity.ok(companyService.getCompanys().get(companyService.getCompanys().size()-1));
//    }
//    @PutMapping("/companies/{companyId}")
//    public ResponseEntity updateCompany(@PathVariable long companyId,@RequestBody Company company){
//        Company searchedCompany = companyService.getCompanys().stream()
//                .filter(company1 -> company1.getCompanyId()==companyId)
//                .findFirst()
//                .orElse(null);
//        if(searchedCompany!= null){
//            searchedCompany.setCompanyName(company.getCompanyName());
//            searchedCompany.setEmployeesNumber(company.getEmployeesNumber());
//            return ResponseEntity.ok(searchedCompany);
//        }
//        return ResponseEntity.notFound().build();
//    }
//    @DeleteMapping("/companies/{companyId}")
//    public ResponseEntity deleteEmployeesOfCompany(@PathVariable long companyId) {
//        Company searchedCompany = companyService.getCompanys().stream()
//                .filter(company1 -> company1.getCompanyId() == companyId)
//                .findFirst()
//                .orElse(null);
//        if (searchedCompany != null) {
//            List<Employee> employees = searchedCompany.getEmployees();
//            searchedCompany.setEmployees(null);
//            return ResponseEntity.ok(employees);
//        }
//        return ResponseEntity.notFound().build();
//    }
}
