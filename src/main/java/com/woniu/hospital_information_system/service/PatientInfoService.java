package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.entity.PatientInfo;

import java.util.List;

public interface PatientInfoService {
    //获取所有住院患者信息
    List<PatientInfo> getAllPatientInfo();
    //添加住院患者信息
    void addPatientInfo(PatientInfoDTO patientInfoDTO);
}
