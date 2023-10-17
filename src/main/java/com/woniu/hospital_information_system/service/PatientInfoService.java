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
    PatientInfo getPatientInfoByPatientId(int patientId);
    //修改住院患者信息-床位
    void modifyPatientInfoByPatientId(int patientInfoId,int locationId);
    //添加出院诊断
    void dischargeDiagnosis(PatientInfoDTO patientInfoDTO);
    //清空床位
    void updateLocationId(Integer patientId);
    //办理出院
    void completeDischarge(PatientInfoDTO patientInfoDTO);
    //修改住院患者信息
    void modifyPatientInfo(PatientInfoDTO patientInfoDTO);
}
