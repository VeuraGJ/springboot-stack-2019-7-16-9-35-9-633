package com.tw.apistackbase.respository;

import com.tw.apistackbase.entity.Company;
import com.tw.apistackbase.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CompanyRepository {
    private List<Employee> firstEmployees = new ArrayList<>();
    private List<Employee> secondEmployees = Arrays.asList(
            new Employee(1,"tengxun1",20,"male",9000),
            new Employee(7,"ateng2",19,"female",7000));
    private List<Company> companys = new ArrayList<>();

    public CompanyRepository() {
        for(int i=0;i<16;i++){
            firstEmployees.add(new Employee(i,"alibaba"+i,20,"male",9000));
        }
        companys.add(new Company(1,"alibaba",firstEmployees,3));
        companys.add(new Company(2,"tengxun",secondEmployees,2));
    }

    public List<Company> getCompanys() {
        return companys;
    }
}
