package com.tw.apistackbase.controller;

import com.google.gson.Gson;
import com.tw.apistackbase.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void should_return_employees_when_call_get_employees_api() throws Exception {
        mockMvc.perform(get("/employees"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(10));
    }
    @Test
    public void should_return_five_employees_when_call_get_employees_api() throws Exception {
        mockMvc.perform(get("/employees?page=1&pageSize=5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(5));
    }
    @Test
    public void should_return_specific_employee_when_call_get_specific_employee_api() throws Exception {
        mockMvc.perform(get("/employees/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("lala1"));
    }
    @Test
    public void should_return_specific_gender_employees_when_call_get_specific_gender_employees_api() throws Exception {
        mockMvc.perform(get("/employees?gender=male"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(5));
    }
    @Test
    public void should_return_new_employee_when_call_post_employees_api() throws Exception {
        Gson gson = new Gson();
        Employee employee = new Employee("weiwei",20,"female",9800);
        mockMvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(employee)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("weiwei"));
    }
    @Test
    public void should_return_update_employee_when_call_put_employees_api() throws Exception {
        Gson gson = new Gson();
        Employee employee = new Employee("weiwei",20,"female",9800);
        mockMvc.perform(put("/employees/1").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(employee)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("weiwei"));
    }
    @Test
    public void should_return_delete_employee_when_call_delete_employees_api() throws Exception {
        mockMvc.perform(delete("/employees/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("lala1"));
    }

}