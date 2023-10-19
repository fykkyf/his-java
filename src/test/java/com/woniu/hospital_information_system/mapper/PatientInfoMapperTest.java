package com.woniu.hospital_information_system.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PatientInfoMapperTest {
    @Autowired
    PatientInfoMapper patientInfoMapper;

    @Test
    void selectAllPatientInfos() {
        System.out.println(patientInfoMapper.selectAllPatientInfos());
    }
}