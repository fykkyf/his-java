package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.DTO.PatientOrderDTO;
import com.woniu.hospital_information_system.entity.PatientInfo;

import java.util.List;

public interface PatientOrderService {
    //获取所有住院患者医嘱信息
    List<PatientInfo> getAllPatientOrders();
    //添加住院患者医嘱信息
    void addPatientOrder(PatientOrderDTO patientOrderDTO);
    //根据住院患者医嘱id查询患者医嘱信息
    PatientInfo getPatientOrderByPatientId(int patientId);
}
