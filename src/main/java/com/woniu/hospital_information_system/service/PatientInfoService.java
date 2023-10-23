package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.entity.PatientInfo;
import com.woniu.hospital_information_system.entity.VO.PatientInfoVO;

import java.util.List;

public interface PatientInfoService {
    //获取所有住院患者信息
    PatientInfoVO getAllPatientInfos(int pageNum,int pageSize);
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
    //添加住院患者入院诊断
    void admissionDiagnosis(PatientInfoDTO patientInfoDTO);
    //模糊查询住院患者信息
    List<PatientInfo> getPatientInfoByKeyWord(PatientInfoDTO patientInfoDTO);

    void finishPayment(Integer patientId);
    //根据身份证查询门诊信息
    PatientInfoVO getVisitorInfoByIdNumber(String idNumber);
    //查询未安排床位信息的住院患者信息
    List<PatientInfo> getPatientInfosByNoLocation(PatientInfoDTO patientInfoDTO);
    PatientInfoVO getAllPatientInfosByNoLocation(int pageNum, int pageSize);
    //获取所有住院患者信息--出院办理
    PatientInfoVO getAllDischarge(Integer pageNum, Integer pageSize);

    List<PatientInfo> getPatientInfoByLocation();

    void addLocationId(Integer locationId,Integer patientId);

    List<PatientInfo> getPatientInfoByPatientIdAndLocation(Integer patientId);
}
