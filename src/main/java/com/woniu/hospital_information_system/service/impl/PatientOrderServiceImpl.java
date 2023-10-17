package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.entity.DTO.PatientOrderDTO;
import com.woniu.hospital_information_system.entity.DTO.TreatmentDTO;
import com.woniu.hospital_information_system.entity.PatientInfo;
import com.woniu.hospital_information_system.entity.PatientOrder;
import com.woniu.hospital_information_system.entity.Treatment;
import com.woniu.hospital_information_system.mapper.PatientBillMapper;
import com.woniu.hospital_information_system.mapper.PatientInfoMapper;
import com.woniu.hospital_information_system.mapper.PatientOrderMapper;
import com.woniu.hospital_information_system.service.PatientOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class PatientOrderServiceImpl implements PatientOrderService {
    @Autowired
    PatientOrderMapper patientOrderMapper;
    @Autowired
    PatientInfoMapper patientInfoMapper;
    @Autowired
    PatientBillMapper patientBillMapper;
    private boolean flog = true;

    /*
    * 获取所有住院患者医嘱信息
    * */
    @Override
    public List<PatientInfo> getAllPatientOrders() {
        return patientOrderMapper.selectAllPatientOrders();
    }

    /*
    * 医生给住院患者下医嘱
    * */
    @Override
    public void addPatientOrder(PatientOrderDTO patientOrderDTO) {
        for (TreatmentDTO treatment : patientOrderDTO.getTreatments()) {
            PatientOrder patientOrder = new PatientOrder();
            patientOrder.setPatientOrderId(patientOrderDTO.getPatientOrderId());
            patientOrder.setPatientId(patientOrderDTO.getPatientId());
            patientOrder.setDoctorId(patientOrderDTO.getDoctorId());
            patientOrder.setTreatmentId(treatment.getTreatmentId());
            patientOrder.setTreatmentName(treatment.getTreatmentName());
            patientOrder.setAdministrationId(patientOrderDTO.getAdministrationId());
            patientOrder.setDosageId(patientOrderDTO.getDosageId());
            patientOrder.setTreatmentCount(treatment.getTreatmentCount());
            patientOrder.setOrderType(patientOrderDTO.getOrderType());
            patientOrderMapper.addPatientOrderByPatientOrderId(patientOrder);
        }
    }

    /*
    * 根据患者id查询住院医嘱信息
    * */
    @Override
    public PatientInfo getPatientOrderByPatientId(int patientId) {
        return patientOrderMapper.selectPatientOrderByPatientId(patientId);
    }

    /*
     * 更改住院医嘱信息
     * */
    //    @Scheduled(fixedRate = 60*1000)
    @Override
    public void modifyPatientOrderByPatientId(PatientOrderDTO patientOrderDTO) {
        //TODO
        patientOrderMapper.updatePatientOrderByPatientId(patientOrderDTO);
        //        if (patientOrderDTO.getOrderType()==1 || flog){
//            需要循环执行的代码
//            flog = false;
//        }
    }
    //办理出院
    @Transactional
    @Override
    public void dischargePatient(PatientInfoDTO patientInfoDTO) {
        //添加出院医嘱
        patientOrderMapper.dischargePatient(patientInfoDTO);
        //添加出院费用表
        patientBillMapper.dischargePatient(patientInfoDTO);

    }


}
