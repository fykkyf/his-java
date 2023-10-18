package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.VO.PatientBillVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PatientBillServiceImplTest {
    @Autowired
    PatientBillServiceImpl patientBillService;
    @Test
    void test01(){
        List<PatientBillVO> patientBillVOList = patientBillService.getPatientBillVO(1);
        System.out.println(patientBillVOList);
    }

}