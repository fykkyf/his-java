package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.entity.PatientInfo;

import java.util.List;

public interface PatientInfoService {
    //获取所有住院患者信息
    List<PatientInfo> getAllPatientInfos();
    //添加住院患者信息
    void addPatientInfo(PatientInfoDTO patientInfoDTO);
    //根据住院患者id查询患者信息
    PatientInfo getPatientInfoByPatientInfoId(int patientInfoId);
    //修改住院患者信息
    void modifyPatientInfoByPatientInfoId(int patientInfoId,int locationId);

    void dischargeDiagnosis(PatientInfoDTO patientInfoDTO);

    void updateLocationId(Integer patientId);
}
