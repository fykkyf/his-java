package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.service.PatientInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class PatientInfoServiceImplTest {
    @Autowired
    PatientInfoService patientInfoService;

    @Test
    void getAllPatientInfo() {
//        PatientInfoDTO patientInfoDTO = new PatientInfoDTO();
//        patientInfoDTO.setAge(18);
//        patientInfoDTO.setPatientName("流得滑");
//        patientInfoDTO.setIdNumber("110120200001010201");
//        patientInfoDTO.setGender(1);
//        patientInfoService.addPatientInfo(patientInfoDTO);
        System.out.println(patientInfoService.getAllPatientInfos());
    }
}