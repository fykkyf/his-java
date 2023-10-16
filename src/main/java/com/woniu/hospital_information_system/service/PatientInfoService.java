package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.entity.PatientInfo;

import java.util.List;

public interface PatientInfoService {
    List<PatientInfo> getAllPatientInfo();

    void addPatientInfo(PatientInfoDTO patientInfoDTO);
}
