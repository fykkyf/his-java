package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.DTO.PatientOrderDTO;
import com.woniu.hospital_information_system.entity.PatientInfo;
import com.woniu.hospital_information_system.mapper.PatientOrderMapper;
import com.woniu.hospital_information_system.service.PatientOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientOrderServiceImpl implements PatientOrderService {
    @Autowired
    PatientOrderMapper patientOrderMapper;

    /*
    * 获取所有住院患者医嘱信息
    * */
    @Override
    public List<PatientInfo> getAllPatientOrders() {
        return patientOrderMapper.selectAllPatientOrders();
    }

    /*
    * 给住员患者下医嘱
    * */
    @Override
    public void addPatientOrder(PatientOrderDTO patientOrderDTO) {
        patientOrderMapper.addPatientOrderByPatientOrderId(patientOrderDTO);
    }

    /*
    * 根据患者id查询住院医嘱信息
    * */
    @Override
    public PatientInfo getPatientOrderByPatientId(int patientId) {
        return patientOrderMapper.selectPatientOrderByPatientId(patientId);
    }
}
