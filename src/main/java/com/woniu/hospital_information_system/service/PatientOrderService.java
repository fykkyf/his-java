package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.entity.DTO.PatientOrderDTO;
import com.woniu.hospital_information_system.entity.PatientInfo;
import com.woniu.hospital_information_system.entity.PatientOrder;
import com.woniu.hospital_information_system.entity.VO.PatientInfoVO;
import com.woniu.hospital_information_system.entity.VO.PatientOrderVO;

import java.util.List;

public interface PatientOrderService {
    //获取所有住院患者医嘱信息
    PatientOrderVO getAllPatientOrders(int pageNum, int pageSize);
    //添加住院患者医嘱信息
    void addPatientOrder(PatientOrderDTO patientOrderDTO);
    //根据住院患者医嘱id查询患者医嘱信息
    List<PatientOrder> getPatientOrderByPatientId(int patientId);
    //根据病人id更改住院医嘱信息
    void modifyPatientOrderByPatientId(PatientOrderDTO patientOrderDTO);
    //根据病人id更改住院医嘱信息
    void timedExecutionAddPatientOrder();
    //办理出院
    void dischargePatient(PatientInfoDTO patientInfoDTO);
    //审核出院医嘱
    void checkDischarge(Integer status, Integer patientId);

    void finishPayment(Integer patientId);
}
