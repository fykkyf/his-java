package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.entity.PatientInfo;
import com.woniu.hospital_information_system.service.PatientInfoService;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class PatientInfoServiceImplTest {
    @Autowired
    PatientInfoService patientInfoService;
    @Test
    void test01(){
        patientInfoService.updateLocationId(1);
    }
    @Test
    void getAllPatientInfo() {
//        PatientInfoDTO patientInfoDTO = new PatientInfoDTO();
//        patientInfoDTO.setAge(18);
//        patientInfoDTO.setPatientName("流得滑");
//        patientInfoDTO.setIdNumber("110120200001010201");
//        patientInfoDTO.setGender(1);
//        patientInfoService.addPatientInfo(patientInfoDTO);
//        System.out.println(patientInfoService.getAllPatientInfos());
    }
    @Test
    void test02(){
        PatientInfo patientInfoByPatientId = patientInfoService.getPatientInfoByPatientId(1);
        System.out.println(patientInfoByPatientId);
    }
}