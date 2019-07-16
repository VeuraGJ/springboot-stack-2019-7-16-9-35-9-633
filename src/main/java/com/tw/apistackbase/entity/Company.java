package com.tw.apistackbase.entity;

import java.util.List;

public class Company {
    private long companyId;
    private String companyName;
    private int employeesNumber;
    private List<Employee> employees;

    public Company(long companyId, String companyName, List<Employee> employees, int employeesNumber) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.employees = employees;
        this.employeesNumber = employeesNumber;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public int getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(int employeesNumber) {
        this.employeesNumber = employeesNumber;
    }
}
