package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.entity.Location;
import com.woniu.hospital_information_system.entity.PatientInfo;
import com.woniu.hospital_information_system.mapper.PatientInfoMapper;
import com.woniu.hospital_information_system.mapper.VisitorInfoMapper;
import com.woniu.hospital_information_system.service.InsuranceInfoService;
import com.woniu.hospital_information_system.service.LocationService;
import com.woniu.hospital_information_system.service.PatientInfoService;
import com.woniu.hospital_information_system.service.VisitorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientInfoServiceImpl implements PatientInfoService {
    @Autowired
    PatientInfoMapper patientInfoMapper;
    @Autowired
    VisitorInfoService visitorInfoService;
    @Autowired
    InsuranceInfoService insuranceInfoService;
    @Autowired
    LocationService locationService;
    /*
    * 获取所有住院患者信息
    * */
    @Override
    public List<PatientInfo> getAllPatientInfos() {
        return patientInfoMapper.selectAllPatientInfos();
    }

    /*
     * 添加住院患者信息
     * */
    @Transactional
    @Override
    public void addPatientInfo(PatientInfoDTO patientInfoDTO) {
        PatientInfo patientInfo = new PatientInfo();
        //TODO:转换类型PatientInfoDTO->PatientInfo
        //查询门诊诊断（diagnosisId）+基础信息
        //有门诊id就添加门诊ID、门诊诊断ID
        if (patientInfoDTO.getVisitorId() != null) {
            patientInfo.setVisitorId(patientInfoDTO.getVisitorId());
            patientInfo.setClinicDiagnosisId(visitorInfoService.getVisitorInfoByVisitorId(patientInfoDTO.getVisitorId()).getDiseaseId());
        }
        //根据身份证号查询住院患者信息
        List<PatientInfo> patientInfos = patientInfoMapper.selectPatientInfoByIdNumber(patientInfoDTO.getIdNumber());
        //获取结算状态为1的集合
        List<PatientInfo> collect = patientInfos.stream().filter(patientInfo1 -> patientInfo1.getPaymentStatus() == 0).collect(Collectors.toList());
        if (collect.size() != 0) {
            //TODO:抛住院费用未结算异常
            System.out.println("未结算");
        }
        //已结清费用则给住院患者对象赋值
        patientInfo.setPatientName(patientInfoDTO.getPatientName());//姓名
        patientInfo.setAge(patientInfoDTO.getAge());//年龄
        patientInfo.setGender(patientInfoDTO.getGender());//性别
        patientInfo.setIdNumber(patientInfoDTO.getIdNumber());//身份证号
        patientInfo.setUnitId(patientInfoDTO.getUnitId());//科室id
        patientInfo.setDoctorId(patientInfoDTO.getDoctorId());//医生id
        //根据身份证查询医保信息
        if (insuranceInfoService.getInsuranceInfoByIdNumber(patientInfoDTO.getIdNumber()) != null) {
            //有医保
            patientInfo.setInsuranceStatus(1);
        } else {
            //无医保
            patientInfo.setInsuranceStatus(0);
        }
        //调用insert方法，向数据库添加住院患者信息
//        patientInfoMapper.insertPatientInfo(patientInfo);
        System.out.println("执行添加");
    }

    /*
    * 根据住院患者id查询住院患者信息
    * */
    @Override
    public PatientInfo getPatientInfoByPatientInfoId(int patientId) {
        return patientInfoMapper.selectPatientInfoByPatientInfoId(patientId);
    }

    /*
     * 给患者添加床位
     * */
    @Transactional
    @Override
    public void modifyPatientInfoByPatientInfoId(int patientId,int locationId) {
        patientInfoMapper.updatePatientInfoByPatientInfoId(patientId,locationId);
        //更改床位状态
        locationService.modifyLocationStatusByLocationId(locationId);
    }

}
