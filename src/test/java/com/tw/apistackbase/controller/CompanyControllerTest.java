package com.tw.apistackbase.controller;


import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;
import com.tw.apistackbase.entity.Company;
import com.tw.apistackbase.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void should_return_companies_when_call_get_companies_api() throws Exception {
        mockMvc.perform(get("/companies"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }
    @Test
    public void should_return_specific_company_when_call_get_specific_company_api() throws Exception {
        mockMvc.perform(get("/companies/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.companyName").value("alibaba"));
    }
    @Test
    public void should_return_employees_of_specific_company_when_call_get_employees_of_specific_company_api() throws Exception {
        mockMvc.perform(get("/companies/1/employees"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(16));
    }
    @Test
    public void should_return_five_companies__when_call_get_companies_api() throws Exception {
        mockMvc.perform(get("/companies?page=1&pageSize=5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }
    @Test
    public void should_return_company__when_call_post_company_api() throws Exception {
        Gson gson = new Gson();
        Company company = new Company();
        company.setCompanyName("lala");
        company.setEmployeesNumber(1);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(22,"lala",23,"female",9000));
        company.setEmployees(employeeList);
        mockMvc.perform(post("/companies").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(company)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.companyName").value("lala"));
    }

}