package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.mapper.PatientBillMapper;
import com.woniu.hospital_information_system.mapper.PatientOrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PatientOrderServiceImplTest {
    @Autowired
    PatientOrderMapper patientOrderMapper;
    @Autowired
    PatientBillMapper patientBillMapper;
    @Test
    void dischargePatient() {
        PatientInfoDTO patientInfoDTO = new PatientInfoDTO();
        patientInfoDTO.setPatientId(1);
        patientInfoDTO.setDoctorId(2);
        patientOrderMapper.dischargePatient(patientInfoDTO);
        //添加出院费用表
        patientBillMapper.dischargePatient(patientInfoDTO);
    }
    @Test
    void checkDischarge(){
        patientOrderMapper.checkDischarge(2,2);
    }
}