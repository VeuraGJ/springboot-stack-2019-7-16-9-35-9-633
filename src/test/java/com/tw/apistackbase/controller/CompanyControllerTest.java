package com.tw.apistackbase.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class CompanyControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void should_return_companies() throws Exception {
        mockMvc.perform(get("/companies"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"companyId\": 1,\n" +
                        "        \"companyName\": \"alibaba\",\n" +
                        "        \"employeesNumber\": 3,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"alibaba1\",\n" +
                        "                \"age\": 20,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 6000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"aliba2\",\n" +
                        "                \"age\": 19,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 7000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 4,\n" +
                        "                \"name\": \"alibayy\",\n" +
                        "                \"age\": 21,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 8000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"companyId\": 2,\n" +
                        "        \"companyName\": \"tengxun\",\n" +
                        "        \"employeesNumber\": 2,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"tengxun1\",\n" +
                        "                \"age\": 20,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 9000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 7,\n" +
                        "                \"name\": \"ateng2\",\n" +
                        "                \"age\": 19,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 7000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    }\n" +
                        "]"));
    }

}