package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.PatientInfo;
import com.woniu.hospital_information_system.mapper.PatientInfoMapper;
import com.woniu.hospital_information_system.service.PatientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientInfoServiceImpl implements PatientInfoService {
    @Autowired
    PatientInfoMapper patientInfoMapper;
    @Override
    public List<PatientInfo> getAllPatientInfo() {
        return patientInfoMapper.selectAllPatientInfo();
    }
}
