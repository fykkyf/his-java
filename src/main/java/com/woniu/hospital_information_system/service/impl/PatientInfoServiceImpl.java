package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.entity.Location;
import com.woniu.hospital_information_system.entity.PatientInfo;
import com.woniu.hospital_information_system.entity.VO.PatientInfoVO;
import com.woniu.hospital_information_system.mapper.*;
import com.woniu.hospital_information_system.service.InsuranceInfoService;
import com.woniu.hospital_information_system.service.LocationService;
import com.woniu.hospital_information_system.service.PatientInfoService;
import com.woniu.hospital_information_system.service.VisitorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    @Autowired
    PatientBillMapper patientBillMapper;
    @Autowired
    UnitMapper unitMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    DiseaseMapper diseaseMapper;
    /*
    * 获取所有住院患者信息
    * */
    @Override
    public List<PatientInfoVO> getAllPatientInfos() {
        List<PatientInfo> patientInfos = patientInfoMapper.selectAllPatientInfos();
        List<PatientInfoVO> patientInfoVOS = new ArrayList<>();
        for (PatientInfo patientInfo : patientInfos) {
            PatientInfoVO patientInfoVO = new PatientInfoVO();
            patientInfoVO.setPatientId(patientInfo.getPatientId());
            if (patientInfo.getVisitorId()!=null){
                patientInfoVO.setVisitorId(patientInfo.getVisitorId());
            }
            patientInfoVO.setPatientName(patientInfo.getPatientName());
            patientInfoVO.setAge(patientInfo.getAge());
            patientInfoVO.setGender(patientInfo.getGender());
            patientInfoVO.setIdNumber(patientInfo.getIdNumber());
            patientInfoVO.setInsuranceStatus(patientInfo.getInsuranceStatus());
            patientInfoVO.setInTime(patientInfo.getInTime());
            if (patientInfo.getOutTime()!=null){
                patientInfoVO.setOutTime(patientInfo.getOutTime());
            }
            if (patientInfo.getLocationId()!=null){
                patientInfoVO.setLocationId(patientInfo.getLocationId());
            }
            if (patientInfo.getPaidTime()!=null){
                patientInfoVO.setPaidTime(patientInfo.getPaidTime());
            }
            patientInfoVO.setStayStatus(patientInfo.getStayStatus());
            patientInfoVO.setPaymentStatus(patientInfo.getPaymentStatus());
            //获取科室
            if (patientInfo.getUnitId()!=null){
                patientInfoVO.setUnit(unitMapper.selectUnitByUnitId(patientInfo.getUnitId()));
            }
            //获取医生
            if (patientInfo.getDoctorId()!=null){
                patientInfoVO.setEmployee(employeeMapper.selectEmployeeById(patientInfo.getDoctorId()));
            }
            //获取疾病--门诊诊断
            if(patientInfo.getClinicDiagnosisId()!=null){
                patientInfoVO.setClinicDiagnosis(diseaseMapper.selectDiseaseById(patientInfo.getClinicDiagnosisId()));
            }
            //获取疾病--入院诊断
            if(patientInfo.getAdmissionDiagnosisId()!=null){
                patientInfoVO.setAdmissionDiagnosis(diseaseMapper.selectDiseaseById(patientInfo.getAdmissionDiagnosisId()));
            }
            //获取疾病--出院诊断
            if(patientInfo.getDischargeDiagnosisId()!=null){
                patientInfoVO.setDischargeDiagnosis(diseaseMapper.selectDiseaseById(patientInfo.getDischargeDiagnosisId()));
            }
            patientInfoVOS.add(patientInfoVO);
        }
        return patientInfoVOS;
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
    public PatientInfo getPatientInfoByPatientId(int patientId) {
        return patientInfoMapper.selectPatientInfoByPatientId(patientId);
    }

    /*
     * 给患者添加床位
     * */
    @Transactional
    @Override
    public void modifyPatientInfoByPatientId(int patientId,int locationId) {
        patientInfoMapper.updatePatientInfoByPatientInfoId(patientId,locationId);
        //更改床位状态
        locationService.modifyLocationStatusByLocationId(locationId);
    }

    /*
    * 添加入院诊断
    * */
    @Override
    public void admissionDiagnosis(PatientInfoDTO patientInfoDTO) {
        PatientInfo patientInfo = convertPatientInfo(patientInfoDTO);
        patientInfoMapper.admissionDiagnosis(patientInfo);
    }

    /*
    * 模糊查询住院患者信息
    * */
    @Override
    public List<PatientInfo> getPatientInfoByKeyWord(PatientInfoDTO patientInfoDTO) {
        return patientInfoMapper.selectPatientInfoByKeyWord(convertPatientInfo(patientInfoDTO));
    }

    /*
    * 添加出院诊断
    * */
    @Override
    public void dischargeDiagnosis(PatientInfoDTO patientInfoDTO) {
        patientInfoMapper.dischargeDiagnosis(convertPatientInfo(patientInfoDTO));
    }

    @Override
    public void updateLocationId(Integer patientId) {
        patientInfoMapper.updateLocationId(patientId);
    }

    @Override
    public void completeDischarge(PatientInfoDTO patientInfoDTO) {
        patientInfoMapper.completeDischarge(patientInfoDTO);
        //费用结算
        patientBillMapper.completeDischarge(patientInfoDTO);
    }

    /*
    * 修改住院患者信息
    * 转科
    * */
    @Override
    public void modifyPatientInfo(PatientInfoDTO patientInfoDTO) {
        patientInfoMapper.updatePatientInfo(convertPatientInfo(patientInfoDTO));
    }


    /*
    * patientInfoDTO-->patientInfo
    * */
    private PatientInfo convertPatientInfo(PatientInfoDTO patientInfoDTO) {
        PatientInfo patientInfo = new PatientInfo();
        if (patientInfoDTO.getPatientId()!=null){
            patientInfo.setPatientId(patientInfoDTO.getPatientId());
        }
        if (patientInfoDTO.getPatientName()!=null){
            patientInfo.setPatientName(patientInfoDTO.getPatientName());
        }
        if (patientInfoDTO.getVisitorId()!=null){
            patientInfo.setVisitorId(patientInfoDTO.getVisitorId());
        }
        if (patientInfoDTO.getGender()!=null){
            patientInfo.setGender(patientInfoDTO.getGender());
        }
        if (patientInfoDTO.getAge()!=null){
            patientInfo.setAge(patientInfoDTO.getAge());
        }
        if (patientInfoDTO.getIdNumber()!=null){
            patientInfo.setIdNumber(patientInfoDTO.getIdNumber());
        }
        if (patientInfoDTO.getUnitId()!=null){
            patientInfo.setUnitId(patientInfoDTO.getUnitId());
        }
        if (patientInfoDTO.getDoctorId()!=null){
            patientInfo.setDoctorId(patientInfoDTO.getDoctorId());
        }
        if (patientInfoDTO.getInsuranceStatus()!=null){
            patientInfo.setInsuranceStatus(patientInfoDTO.getInsuranceStatus());
        }
        if (patientInfoDTO.getInTime()!=null){
            patientInfo.setInTime(patientInfoDTO.getInTime());
        }
        if (patientInfoDTO.getOutTime()!=null){
            patientInfo.setOutTime(patientInfoDTO.getOutTime());
        }
        if (patientInfoDTO.getClinicDiagnosisId()!=null){
            patientInfo.setClinicDiagnosisId(patientInfoDTO.getClinicDiagnosisId());
        }
        if (patientInfoDTO.getAdmissionDiagnosisId()!=null){
            patientInfo.setAdmissionDiagnosisId(patientInfoDTO.getAdmissionDiagnosisId());
        }
        if (patientInfoDTO.getDischargeDiagnosisId()!=null){
            patientInfo.setDischargeDiagnosisId(patientInfoDTO.getDischargeDiagnosisId());
        }
        if (patientInfoDTO.getLocationId()!=null){
            patientInfo.setLocationId(patientInfoDTO.getLocationId());
        }
        if (patientInfoDTO.getPaidTime()!=null){
            patientInfo.setPaidTime(patientInfoDTO.getPaidTime());
        }
        if (patientInfoDTO.getStayStatus()!=null){
            patientInfo.setStayStatus(patientInfoDTO.getStayStatus());
        }
        if (patientInfoDTO.getPaymentStatus()!=null){
            patientInfo.setPaymentStatus(patientInfoDTO.getPaymentStatus());
        }
        return patientInfo;
    }

}
