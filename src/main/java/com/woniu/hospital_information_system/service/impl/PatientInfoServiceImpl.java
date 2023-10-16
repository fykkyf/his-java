package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.entity.PatientInfo;
import com.woniu.hospital_information_system.entity.VisitorInfo;
import com.woniu.hospital_information_system.mapper.PatientInfoMapper;
import com.woniu.hospital_information_system.mapper.VisitorInfoMapper;
import com.woniu.hospital_information_system.service.PatientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientInfoServiceImpl implements PatientInfoService {
    @Autowired
    PatientInfoMapper patientInfoMapper;
    @Autowired
    VisitorInfoMapper visitorInfoMapper;
    @Override
    public List<PatientInfo> getAllPatientInfo() {
        return patientInfoMapper.selectAllPatientInfo();
    }

    @Override
    public void addPatientInfo(PatientInfoDTO patientInfoDTO) {
        PatientInfo patientInfo = new PatientInfo();
        //TODO:转换类型PatientInfoDTO->PatientInfo
        //查询门诊诊断（diagnosisId）+基础信息
        VisitorInfo visitorInfo = visitorInfoMapper.getVisitorInfoByVisitorId(patientInfoDTO.getVisitorId());
        patientInfo.setPatientName(visitorInfo.getVisitorName());

        //通过身份证号获取医保信息 添加属性insuranceStatus


        patientInfoMapper.insertPatientInfo(patientInfo);
    }


}
