package com.tw.apistackbase.controller;

import com.tw.apistackbase.entity.Company;
import com.tw.apistackbase.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CompanyService {
    private List<Employee> firstEmployees = Arrays.asList(
            new Employee(1,"alibaba1",20,"male",6000),
            new Employee(2,"aliba2",19,"male",7000),
            new Employee(4,"alibayy",21,"female",8000));
    private List<Employee> secondEmployees = Arrays.asList(
            new Employee(1,"tengxun1",20,"male",9000),
            new Employee(7,"ateng2",19,"female",7000));
    private List<Company> companys = new ArrayList<>();

    public CompanyService() {
        companys.add(new Company(1,"alibaba",firstEmployees,3));
        companys.add(new Company(2,"tengxun",secondEmployees,2));
    }

    public List<Company> getCompanys() {
        return companys;
    }
}
