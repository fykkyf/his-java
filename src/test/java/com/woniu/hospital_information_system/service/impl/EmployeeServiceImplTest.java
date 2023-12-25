package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.DTO.EmployeeDTO;
import com.woniu.hospital_information_system.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeServiceImplTest {
    @Autowired
    EmployeeService employeeService;
//    @Test
//    void test01(){
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeName("aaa");
//        employeeDTO.setRoleId(1);
//        employeeDTO.setUnitId(1);
//        employeeService.addNewEmployee(employeeDTO);
//    }
}