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
    public ResponseEntity getAllCompanies(@RequestParam(value = "page",defaultValue = "0")int page,
                                          @RequestParam(value = "pageSize",defaultValue = "0")int pageSize){
        if(page == 0||pageSize == 0){
            return ResponseEntity.ok(companyRepository.getCompanys());
        }
        int endIndex = page * pageSize;
        if(endIndex > companyRepository.getCompanys().size()){
            endIndex = companyRepository.getCompanys().size();
        }
        return ResponseEntity.ok(companyRepository.getCompanys().subList((page-1)*pageSize,endIndex));
    }
    @GetMapping("/companies/{companyId}")
    public ResponseEntity getSpecificCompany(@PathVariable long companyId){
        Company specificCompany = companyRepository.getCompanys().stream()
                .filter(company -> company.getCompanyId()==companyId)
                .findFirst()
                .orElse(null);
        if(specificCompany!= null){
            return ResponseEntity.ok(specificCompany);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/companies/{companyId}/employees")
    public ResponseEntity getEmployeesOfSpecificCompany(@PathVariable long companyId) {
        Company specificCompany = companyRepository.getCompanys().stream()
                .filter(company -> company.getCompanyId() == companyId)
                .findFirst()
                .orElse(null);
        if (specificCompany != null) {
            return ResponseEntity.ok(specificCompany.getEmployees());
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping("/companies")
    public ResponseEntity createCompany(@RequestBody Company company){
        company.setCompanyId(11);
        companyRepository.getCompanys().add(company);
        return ResponseEntity.ok(companyRepository.getCompanys().get(companyRepository.getCompanys().size()-1));
    }
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
