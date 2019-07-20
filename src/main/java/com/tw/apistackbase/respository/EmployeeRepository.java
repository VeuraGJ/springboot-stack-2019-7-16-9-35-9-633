package com.tw.apistackbase.respository;

import com.tw.apistackbase.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class EmployeeRepository {
    private List<Employee> employees = new ArrayList<>();
    public EmployeeRepository(){
        for(int i =0;i<5;i++){
            employees.add(new Employee(i,"lala"+i,20+i,"male",8000+i));
        }
        for(int i =5;i<10;i++){
            employees.add(new Employee(i,"lala"+i,20+i,"female",8000+i));
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
