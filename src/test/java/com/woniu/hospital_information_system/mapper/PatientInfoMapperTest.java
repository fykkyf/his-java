package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.VO.EmployeeVO;
import com.woniu.hospital_information_system.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PatientInfoMapperTest {
    @Autowired
    PatientInfoMapper patientInfoMapper;
    @Autowired
    EmployeeService employeeService;
    @Test
    void selectAllPatientInfos() {
        System.out.println(patientInfoMapper.selectAllPatientInfos());
    }
    @Test
    void test01(){
        List<EmployeeVO> list = employeeService.getAllVO();
        System.out.println(list);
    }
}